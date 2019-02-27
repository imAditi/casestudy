import com.example.casestudyapp.domain.User;
import com.example.casestudyapp.repositoryimpl.UserRepository;

public class TestDao {

	public static void main(String[] args) {
		UserRepository dao = new UserRepository();
		User user = dao.getUser(1);
		System.out.println(user.getName());
	}
}
