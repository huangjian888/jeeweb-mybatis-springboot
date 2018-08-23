package cn.jeeweb.modules.common.jcaptcha;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.imageio.ImageIO;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 生成验证码
 * 
 * @author auth_team
 *
 */
public class JCaptchaFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		response.setDateHeader("Expires", 0L);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");

		String id = request.getRequestedSessionId();
		BufferedImage bi = JCaptcha.captchaService.getImageChallengeForID(id);

		ServletOutputStream out = response.getOutputStream();

		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
	}

}
