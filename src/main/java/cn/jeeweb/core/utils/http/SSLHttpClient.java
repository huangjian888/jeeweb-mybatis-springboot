package cn.jeeweb.core.utils.http;

import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class SSLHttpClient {

	public DefaultHttpClient registerSSL(String hostname, String protocol, int port, String scheme)
			throws NoSuchAlgorithmException, KeyManagementException {
		DefaultHttpClient httpclient = new DefaultHttpClient();

		SSLContext ctx = SSLContext.getInstance(protocol);

		X509TrustManager tm = new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] chain, String authType)
					throws CertificateException {
			}

			public void checkServerTrusted(X509Certificate[] chain, String authType)
					throws CertificateException {
				if ((chain == null) || (chain.length == 0))
					throw new IllegalArgumentException("null or zero-length certificate chain");
				if ((authType == null) || (authType.length() == 0))
					throw new IllegalArgumentException("null or zero-length authentication type");

				boolean br = false;
				Principal principal = null;
				for (X509Certificate x509Certificate : chain) {
					principal = x509Certificate.getSubjectX500Principal();
					if (principal != null) {
						br = true;
						return;
					}
				}
				if (!(br))
					throw new CertificateException("服务端证书验证失败！");
			}

			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}

		};
		ctx.init(null, new TrustManager[] { tm }, new SecureRandom());

		SSLSocketFactory socketFactory = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		Scheme sch = new Scheme(scheme, port, socketFactory);

		httpclient.getConnectionManager().getSchemeRegistry().register(sch);
		return httpclient;
	}
}