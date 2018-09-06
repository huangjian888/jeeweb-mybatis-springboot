package cn.jeeweb.modules.sys.service.impl;

import cn.jeeweb.modules.sys.entity.User;
//import com.alibaba.dubbo.config.annotation.Service;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("passwordService")
public class PasswordService {

	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	
	@Value(value = "md5")
	private String algorithmName = "md5";
	@Value(value = "2")
	private final int hashIterations = 2;

	public void encryptPassword(User user) {
		user.setSalt(randomNumberGenerator.nextBytes().toHex());
		String newPassword = new SimpleHash(algorithmName, user.getPassword(),
				ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();
		user.setPassword(newPassword);
	}
}
