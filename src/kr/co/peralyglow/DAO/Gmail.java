package kr.co.peralyglow.DAO;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("cssimm@gmail.com", "cs9059666"); //구�?계정
		//return new PasswordAuthentication("?��?��?��", "비�?번호"); //구�?계정
	}
}
