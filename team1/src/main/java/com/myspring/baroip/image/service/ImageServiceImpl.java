// 2021.12.09 ??????

package com.myspring.baroip.image.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.baroip.image.dao.ImageDAO;
import com.myspring.baroip.image.vo.ImageVO;

@Service("imageService")
@Transactional(propagation=Propagation.REQUIRED)
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private ImageDAO imageDAO;

	@Override
	public String addImageFile(ImageVO imageVO) throws Exception {
		
		String imageName = imageDAO.insertImageFile(imageVO);
		
		return imageName;
	}
	
	// option의 파라미터는 match_id/값 , image_category/값의 두가지 Map이 들어가야한다..
	@Override
	public ImageVO selectProductImage(Map<String, String> option) throws Exception {
		ImageVO image = imageDAO.selectProductImages(option);
		
		return image;
		
		
	}
	
	@Override
	public List<String> selectImageCategory(String match_id) throws Exception {
		
		List<String> categoryList = imageDAO.selectImageCategory(match_id);
		
		return categoryList;
		
	}
	
}
