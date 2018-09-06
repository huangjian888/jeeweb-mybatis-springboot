package cn.jeeweb.core.common.jcaptcha;

import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.UniColorBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomListColorGenerator;
import com.octo.captcha.component.image.deformation.ImageDeformation;
import com.octo.captcha.component.image.deformation.ImageDeformationByFilters;
import com.octo.captcha.component.image.fontgenerator.FontGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.DecoratedRandomTextPaster;
import com.octo.captcha.component.image.textpaster.TextPaster;
import com.octo.captcha.component.image.textpaster.textdecorator.TextDecorator;
import com.octo.captcha.component.image.wordtoimage.DeformedComposedWordToImage;
import com.octo.captcha.component.image.wordtoimage.WordToImage;
import com.octo.captcha.component.word.FileDictionary;
import com.octo.captcha.component.word.wordgenerator.ComposeDictionaryWordGenerator;
import com.octo.captcha.component.word.wordgenerator.WordGenerator;
import com.octo.captcha.engine.image.ListImageCaptchaEngine;
import com.octo.captcha.image.gimpy.GimpyFactory;

import java.awt.*;
import java.awt.image.ImageFilter;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: GMailEngine.java
 * @package cn.jeeweb.modules.common.jcaptcha
 * @description: 仿照JCaptcha2.0编写GMail验证码样式的图片引擎.
 * @author: auth_team
 * @date: 2017年6月26日 下午6:02:25
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
@SuppressWarnings("deprecation")
public class GMailEngine extends ListImageCaptchaEngine {
	@Override
	protected void buildInitialFactories() {

		int minWordLength = 5;
		int maxWordLength = 5;
		int fontSize = 24;
		int imageWidth = 100;
		int imageHeight = 40;

		// word generator
		WordGenerator dictionnaryWords = new ComposeDictionaryWordGenerator(new FileDictionary("toddlist"));

		// word2image components
		TextPaster randomPaster = new DecoratedRandomTextPaster(minWordLength, maxWordLength,
				new RandomListColorGenerator(
						new Color[] { new Color(23, 170, 27), new Color(220, 34, 11), new Color(23, 67, 172) }),
				new TextDecorator[] {});

		BackgroundGenerator background = new UniColorBackgroundGenerator(imageWidth, imageHeight, Color.white);
		FontGenerator font = new RandomFontGenerator(fontSize, fontSize,
				new Font[] { new Font("nyala", Font.BOLD, fontSize), new Font("Bell MT", Font.PLAIN, fontSize),
						new Font("Credit valley", Font.BOLD, fontSize) });
		ImageDeformation postDef = new ImageDeformationByFilters(new ImageFilter[] {});
		ImageDeformation backDef = new ImageDeformationByFilters(new ImageFilter[] {});
		ImageDeformation textDef = new ImageDeformationByFilters(new ImageFilter[] {});
		WordToImage word2image = new DeformedComposedWordToImage(font, background, randomPaster, backDef, textDef,
				postDef);
		addFactory(new GimpyFactory(dictionnaryWords, word2image));
	}
}