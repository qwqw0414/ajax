package common;

import java.util.ArrayList;
import java.util.List;

import member.model.vo.Member;

/**
 * Singletone 패턴으로 유지되는 회원리스트
 *
 */

public class MemberSingletone {
	private static MemberSingletone instance;
	
	private List<Member> list;
	
	private MemberSingletone() {
		list = new ArrayList<>();
		list.add(new Member("박보검", "01012341234", "parkBogum.jpg"));
		list.add(new Member("쥴리아 로버츠", "01012341234", "juliaRoberts.jpg"));
		list.add(new Member("맷 데이먼", "01012341234", "mattDamon.jpg"));
	}
	
	public static MemberSingletone getInstance() {
		
		if(instance == null)
			instance = new MemberSingletone();
		
		return instance;
	}

	public List<Member> getList() {
		return list;
	}

}
