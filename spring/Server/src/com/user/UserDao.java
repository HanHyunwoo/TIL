package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.frame.Dao;
import com.mapper.UserMapper;
import com.vo.User;

@Repository("userDao") // default �� ù���� �ҹ���, �̸� �����ؼ� ����ϰ� ���� �� ("xxx")
public class UserDao implements Dao<User> {
	@Autowired // �Ʒ� UserMapper��üŸ���� ã�´�.
	UserMapper mapper; // �갡 ���̹�Ƽ�� �����ϴ� ��

	@Override
	public void insert(User t) {
		mapper.insert(t);
	}

}
