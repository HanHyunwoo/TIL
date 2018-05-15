
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class adminFTP {
	private String server = "70.12.114.146"; // 파일 업로드 할 서버 IP
	private String username = "ozo"; // 사용자 Id
	private String password = "1234"; // 패스워드
	private String defaultPath = "/home/ozo/"; // 저장할 경로

	/**
	 * 
	 * 파일을 업로드 해준다.
	 * 
	 * @param filePath
	 *            자신의 하드에 있는 파일의 경로를 말한다. 파일 경로랑 파일명까지다. ex: c:\\test.jpg
	 * @param destfilePath
	 *            FTP서버에 업로드할 경로를 말한다.
	 * 
	 *            상단의 defaultPath로 기본 위치를 잡고 그 뒤에 경로와 파일명까지 붙여서 쓴다
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
