
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPUploader2 {
	FTPClient ftp = null;

	public static void main(String[] args) throws Exception {
		System.out.println("Start");
		FTPUploader2 FTPUploader2 = new FTPUploader2("70.12.114.146", "ozo", "1234");
		FTPUploader2.uploadFile("C:\\logs\\sensor.log", "sensor.log", "/home/ozo/");
		FTPUploader2.disconnect();
		System.out.println("Done");
	}

	public FTPUploader2(String host, String user, String pwd) throws Exception {
		ftp = new FTPClient();
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		int reply;
		ftp.connect(host);
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			throw new Exception("Exception in connecting to FTP Server");
		}
		ftp.login(user, pwd);
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		ftp.enterRemoteActiveMode(InetAddress.getLocalHost(), 21);
	}

	public void uploadFile(String localFileFullName, String fileName, String hostDir) throws Exception {
		try (InputStream input = new FileInputStream(new File(localFileFullName))) {
			this.ftp.storeFile(hostDir + fileName, input);
		}
	}

	public void disconnect() {
		if (this.ftp.isConnected()) {
			try {
				this.ftp.logout();
				this.ftp.disconnect();
			} catch (IOException f) {
				f.printStackTrace();
			}
		}
	}
}