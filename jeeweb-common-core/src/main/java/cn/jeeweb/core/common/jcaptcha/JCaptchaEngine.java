package cn.jeeweb.core.common.jcaptcha;

import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.FileReaderRandomBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomListColorGenerator;
import com.octo.captcha.component.image.fontgenerator.FontGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.DecoratedRandomTextPaster;
import com.octo.captcha.component.image.textpaster.TextPaster;
import com.octo.captcha.component.image.textpaster.textdecorator.TextDecorator;
import com.octo.captcha.component.image.wordtoimage.ComposedWordToImage;
import com.octo.captcha.component.image.wordtoimage.WordToImage;
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator;
import com.octo.captcha.component.word.wordgenerator.WordGenerator;
import com.octo.captcha.engine.image.ListImageCaptchaEngine;
import com.octo.captcha.image.gimpy.GimpyFactory;

import java.awt.*;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: JCaptchaEngine.java
 * @package cn.jeeweb.modules.common.jcaptcha
 * @description: 生成验证码图片
 * @author: auth_team
 * @date: 2017年6月26日 下午6:02:46
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
@SuppressWarnings("deprecation")
public class JCaptchaEngine extends ListImageCaptchaEngine {
	public static final String IMAGE_CAPTCHA_KEY = "imageCaptcha";// ImageCaptcha对象存放在Session中的key
	public static final String CAPTCHA_INPUT_NAME = "j_captcha";// 验证码输入表单名称
	public static final String CAPTCHA_IMAGE_URL = "/captcha.jpg";// 验证码图片URL
	private static final Integer MIN_WORD_LENGTH = 4;// 验证码最小长度
	private static final Integer MAX_WORD_LENGTH = 4;// 验证码最大长度
	private static final Integer IMAGE_HEIGHT = 28;// 验证码图片高度
	private static final Integer IMAGE_WIDTH = 80;// 验证码图片宽度
	private static final Integer MIN_FONT_SIZE = 16;// 验证码最小字体
	private static final Integer MAX_FONT_SIZE = 16;// 验证码最大字体
	private static final String RANDOM_WORD = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";// 随机字符
	private static final String IMAGE_PATH = "./com/zsw/captcha/";// 随机背景图片路径

	// 验证码随机字体
	private static final Font[] RANDOM_FONT = new Font[] { new Font("nyala", Font.BOLD, MIN_FONT_SIZE),
			new Font("Arial", Font.BOLD, MIN_FONT_SIZE), new Font("Bell MT", Font.BOLD, MIN_FONT_SIZE),
			new Font("Credit valley", Font.BOLD, MIN_FONT_SIZE), new Font("Impact", Font.BOLD, MIN_FONT_SIZE) };
	// 验证码随机颜色
	private static final Color[] RANDOM_COLOR = new Color[] { new Color(255, 255, 255), new Color(255, 220, 220),
			new Color(220, 255, 255), new Color(220, 220, 255), new Color(255, 255, 220), new Color(220, 255, 220) };

	// 生成验证码
	@Override
	protected void buildInitialFactories() {

		RandomListColorGenerator randomListColorGenerator = new RandomListColorGenerator(RANDOM_COLOR);// 验证码随机颜色
		BackgroundGenerator backgroundGenerator = new FileReaderRandomBackgroundGenerator(IMAGE_WIDTH, IMAGE_HEIGHT,
				IMAGE_PATH); // 验证码背景图片
		WordGenerator wordGenerator = new RandomWordGenerator(RANDOM_WORD);
		FontGenerator fontGenerator = new RandomFontGenerator(MIN_FONT_SIZE, MAX_FONT_SIZE, RANDOM_FONT);// 验证码随机字体
		TextDecorator[] textDecorator = new TextDecorator[] {};
		TextPaster textPaster = new DecoratedRandomTextPaster(MIN_WORD_LENGTH, MAX_WORD_LENGTH,
				randomListColorGenerator, textDecorator);
		WordToImage wordToImage = new ComposedWordToImage(fontGenerator, backgroundGenerator, textPaster);
		addFactory(new GimpyFactory(wordGenerator, wordToImage));
	}
}