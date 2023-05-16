package com.problem2;

import java.io.File;

public class FileOperationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "Originally formed in 1600 purely to trade with the Mughal Empire, the Company needed to secure its commercial posts at Calcutta, Bombay and Madras. It purchased land from Indian rulers to build its settlements on, and recruited native armed forces to protect them. Eventually, these evolved into the Bengal, Bombay and Madras Armies.";
		String str2 = "After successfully battling the French for trading supremacy, and simultaneously involving itself in local politics, the Company became India’s leading power following Robert Clive’s victory at Plassey in 1757. In the years that followed, it expanded its Indian domains.";
		
		ReadWriteCenter rwc = new ReadWriteCenter(new File("A.txt"), str1, str2);
	}

}
