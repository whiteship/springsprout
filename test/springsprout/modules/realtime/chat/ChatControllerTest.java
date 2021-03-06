package springsprout.modules.realtime.chat;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springsprout.domain.Meeting;
import springsprout.domain.Member;
import springsprout.domain.Study;
import springsprout.service.security.SecurityService;

/**
 * @author Keesun Baik
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ChatControllerTest {

	@Value("${vertx.chat}") String url;
	@Autowired ChatController chatController;

	@Test
	@Ignore
	public void di(){
		String url = "http://localhost:8888/chat";
		assertThat(this.url, is(url));
		assertThat(chatController.chatUrl, is(url));
	}

	public static class SecurityServiceDummy implements SecurityService {

		@Override
		public Member getCurrentMember() {
			return null;
		}

		@Override
		public Member getPersistentMember() {
			return null;
		}

		@Override
		public int getCurrentMemberId() {
			return 0;
		}

		@Override
		public boolean isAdmin() {
			return false;
		}

		@Override
		public boolean isCurrentUserOrAdmin(int id) {
			return false;
		}

		@Override
		public boolean isStudyManagerOrAdmin(Study study) {
			return false;
		}

		@Override
		public boolean isMeetingManagerOrAdmin(Meeting meeting) {
			return false;
		}

		@Override
		public boolean hasLoggedInUser() {
			return false;
		}
	}
}
