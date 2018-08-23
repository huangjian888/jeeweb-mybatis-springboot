package cn.jeeweb.core.tags.html.builder;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.Validate;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.ResourceLoader;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import com.google.common.collect.Maps;
import cn.jeeweb.core.tags.html.exception.HtmlComponentException;
import cn.jeeweb.core.tags.html.resolver.HtmlComponentDTDEntityResolver;


/**
 * @author auth_team
 * 
 */
public class DefaultHtmlComponentBuilder implements HtmlComponentBuilder, ResourceLoaderAware {
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHtmlComponentBuilder.class);
	private Map<String, String> jsComponents = Maps.newHashMap();
	private Map<String, String> cssComponents = Maps.newHashMap();
	private Map<String, String> fragmentComponents = Maps.newHashMap();
	private String[] fileNames = new String[0];
	private ResourceLoader resourceLoader;
	private EntityResolver entityResolver = new HtmlComponentDTDEntityResolver();

	public void setFileNames(String[] fileNames) {
		this.fileNames = fileNames;
	}

	@Override
	public Map<String, String> getJsComponents() {
		return jsComponents;
	}

	@Override
	public Map<String, String> getCssComponents() {
		return cssComponents;
	}

	@Override
	public Map<String, String> getFragmentComponents() {
		return fragmentComponents;
	}

	@Override
	public void init() throws IOException {
		// clear name cache
		cssComponents.clear();
		jsComponents.clear();
		fragmentComponents.clear();
		boolean flag = this.resourceLoader instanceof ResourcePatternResolver;
		for (String file : fileNames) {
			if (flag) {
				Resource[] resources = ((ResourcePatternResolver) this.resourceLoader).getResources(file);
				buildMap(resources);
			} else {
				Resource resource = ((ResourcePatternResolver) this.resourceLoader).getResource(file);
				buildMap(resource);
			}
		}
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	private void buildMap(Resource[] resources) throws IOException {
		if (resources == null) {
			return;
		}
		for (Resource resource : resources) {
			buildMap(resource);
		}
	}

	@SuppressWarnings({ "rawtypes" })
	private void buildMap(Resource resource) {
		InputSource inputSource = null;
		try {
			inputSource = new InputSource(resource.getInputStream());
			Document document = read(resource.getFile().getAbsolutePath());
			if (isHtmlComponentXml(document)) {
				final Element dynamicHibernateStatement = document.getRootElement();
				Iterator rootChildren = dynamicHibernateStatement.elementIterator();
				while (rootChildren.hasNext()) {
					final Element element = (Element) rootChildren.next();
					final String elementName = element.getName();
					if ("js".equals(elementName)) {
						putStatementToCacheMap(resource, element, jsComponents);
					} else if ("css".equals(elementName)) {
						putStatementToCacheMap(resource, element, cssComponents);
					} else if ("fragment".equals(elementName)) {
						putStatementToCacheMap(resource, element, fragmentComponents);
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.toString());
			throw new HtmlComponentException(e);
		} finally {
			if (inputSource != null && inputSource.getByteStream() != null) {
				try {
					inputSource.getByteStream().close();
				} catch (IOException e) {
					LOGGER.error(e.toString());
					throw new HtmlComponentException(e);
				}
			}
		}

	}

	private Document read(String fileName) throws MalformedURLException, DocumentException {
		SAXReader reader = new SAXReader();
		reader.setEntityResolver(entityResolver);
		Document document = reader.read(new File(fileName));
		return document;

	}

	private void putStatementToCacheMap(Resource resource, final Element element, Map<String, String> statementMap)
			throws IOException {
		String statementId = element.attribute("name").getText().toLowerCase();
		Validate.notEmpty(statementId);
		if (statementMap.containsKey(statementId)) {
			throw new HtmlComponentException(
					"重复的组建语句定义在文件:" + resource.getURI() + "中，必须保证name“" + statementId + "”的唯一.");
		}
		String queryText = element.getText().trim();
		statementMap.put(statementId, queryText);
	}

	private static boolean isHtmlComponentXml(Document document) {
		return "html-component".equals(document.getRootElement().getName());
	}

}