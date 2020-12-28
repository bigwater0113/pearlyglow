package kr.co.peralyglow.DAO;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("구글아이디입력", "구글비밀번호입력");
		 
	}
}
