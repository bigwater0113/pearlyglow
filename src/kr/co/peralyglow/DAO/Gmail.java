package kr.co.peralyglow.DAO;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("���۾��̵�", "���ۺ�й�ȣ");
		 
	}
}
