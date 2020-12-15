package kr.co.peralyglow.DAO;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("cssimm@gmail.com", "cs9059666"); //Íµ¨Í?Í≥ÑÏ†ï
		//return new PasswordAuthentication("?ïÑ?ù¥?îî", "ÎπÑÎ?Î≤àÌò∏"); //Íµ¨Í?Í≥ÑÏ†ï
	}
}
