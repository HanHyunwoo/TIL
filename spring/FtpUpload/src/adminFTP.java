
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class adminFTP {
	private String server = "70.12.114.146"; // ���� ���ε� �� ���� IP
	private String username = "ozo"; // ����� Id
	private String password = "1234"; // �н�����
	private String defaultPath = "/home/ozo/"; // ������ ���

	/**
	 * 
	 * ������ ���ε� ���ش�.
	 * 
	 * @param filePath
	 *            �ڽ��� �ϵ忡 �ִ� ������ ��θ� ���Ѵ�. ���� ��ζ� ���ϸ������. ex: c:\\test.jpg
	 * @param destfilePath
	 *            FTP������ ���ε��� ��θ� ���Ѵ�.
	 * 
	 *            ����� defaultPath�� �⺻ ��ġ�� ��� �� �ڿ� ��ο� ���ϸ���� �ٿ��� ����
	 * @return
	 * 
	 */

	public boolean upLoad(String filePath, String destfilePath) {
		FTPClient ftpClient = new FTPClient();
		ftpClient.setControlEncoding("euc-kr");
		try {
			ftpClient.connect(server);
			int reply = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				System.out.println("FTP server refused connection.");
			} else {
				System.out.println("Connect successful");
				ftpClient.setSoTimeout(10000);
				ftpClient.login(username, password);
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				ftpClient.changeWorkingDirectory(defaultPath);
				File put_file = new File(filePath);
				FileInputStream inputStream = new FileInputStream(put_file);
				boolean result = ftpClient.storeFile(destfilePath, inputStream);
				System.out.println("FILE TRANSPORT STATUS  :" + result);
				inputStream.close();
				ftpClient.logout();
			}

		} catch (SocketException e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		adminFTP ft = new adminFTP();
		boolean a;
		a = ft.upLoad("C:\\logs\\sensor.log","/root/sensor.log");
		
	}
	
}
