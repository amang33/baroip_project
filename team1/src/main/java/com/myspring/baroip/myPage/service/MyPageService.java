// 2022.01.24 윤상현

package com.myspring.baroip.myPage.service;

import java.util.List;
import java.util.Map;

import com.myspring.baroip.notice.vo.NoticeVO;
import com.myspring.baroip.user.vo.UserVO;

public interface MyPageService {

	// user_id 에 해당하는 cart의 전체 수량 select Service
	public int myPageCartCount(UserVO userVO) throws Exception;

	// user_id 에 해당하는 order의 배송완료 상품의 전체 수량 select Service
	public int myPageOrderCount(UserVO userVO) throws Exception;
	
	// 회원정보 수정 서비스
	public int updateMyInfo(UserVO userVO) throws Exception;

	// 조회 조건에 따른 주문 리스트 조회 서비스
	public List<Map<String, Object>> myOrder( Map<String, String> option) throws Exception;
	
	// 주문 상태 변경 서비스
	public void updateOrder(Map<String, String> option) throws Exception;
	
	// 반품 등록 서비스
	public String askRefund(NoticeVO noticeVO) throws Exception;
	
	// 주문 정보 호출 DAO
	public List<Map<String, Object>> orderDetail(String order_id) throws Exception;
	
//	문의 리스트
	public Map<String, Object> questionList(String user_id) throws Exception;
	
//	문의 내역 페이지
	public Map<String, Object> questionDetail(String notice_id) throws Exception;
}
