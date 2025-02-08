
import com.SaTokenAuthApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


@SpringBootTest(classes = SaTokenAuthApp.class)
public class AppTest
{
	@Test
	public void testMD5() throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String pwd = "MO&CO888" + "20171023";
		byte[] md5 = getEncryptMD5Bytes(pwd);
		String b64 = encryptBASE64(md5);
		System.out.println("md5+b64 =>" + b64);
	}

	/**
	 * MD5加密
	 *
	 * @param input
	 * @return
	 */
	public static byte[] getEncryptMD5Bytes(String input) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		byte[] inputBytes = null;
			inputBytes = input.getBytes("UTF-8");

		MessageDigest messageDigest = null;
		messageDigest = MessageDigest.getInstance("MD5");

		messageDigest.update(inputBytes);
		return messageDigest.digest();
	}

	private static String encryptBASE64(byte[] key) {
		return Base64.getEncoder().encodeToString(key);
	}
}
