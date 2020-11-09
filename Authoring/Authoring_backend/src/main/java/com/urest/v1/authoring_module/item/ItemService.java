package com.urest.v1.authoring_module.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.urest.v1.authoring_module.TF.TFRepository;
import com.urest.v1.authoring_module.options.Options;
import com.urest.v1.authoring_module.options.OptionsRepository;
import com.urest.v1.authoring_module.options.OptionsStruct;
import com.urest.v1.authoring_module.TF.TF;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private TFRepository tFRepository;
	@Autowired
	private OptionsRepository optRepository;
	
	
	public List<Item> getAllItems() {
		List<Item> itemList = new ArrayList<>();
		itemRepository.findAll()
		.forEach(itemList::add);
		return itemList;
	}
	
	public List<Item> getAllQpItemsForAuthor(int qpId) {
		return itemRepository.findByAuthorId(qpId);
	}
	
	public List<Item> getAllQpItemsFiltered(Map<String, String> m) {
//		System.out.println("customQuery " + p.toString());
		List<String> cgLvlList = new ArrayList<String>(Arrays.asList(m.get("cgLvl").split(",")));
//		System.out.println(cgLvlList.toString());
		List<String> difLvlList = new ArrayList<String>(Arrays.asList(m.get("difLvl").split(",")));
		System.out.println(difLvlList.toString());
		List<String> typesList = new ArrayList<String>(Arrays.asList(m.get("types").split(",")));
		System.out.println(m.get("startMark"));
		System.out.println(m.get("endMark"));
//		int startMarkInteger=Integer.valueOf(m.get("startMark"));
		int startMarkInteger = 0;
		if(m.get("startMark")!=null)
			startMarkInteger=Integer.parseInt(m.get("startMark").trim());
//		int endMarkInteger=Integer.valueOf(m.get("endMark"));
		int endMarkInteger=100;
		if(m.get("endMark")!=null)
			endMarkInteger=Integer.parseInt(m.get("endMark").trim());
		System.out.println("----------------");
		System.out.println(startMarkInteger);
		System.out.println(endMarkInteger);
		System.out.println("----------------");
		List<Item> t= itemRepository.findByItemId(cgLvlList,difLvlList,typesList,startMarkInteger,endMarkInteger);
		System.out.println("heyy");
		System.out.println(t.toString());
		return t;
	}
	
	public ResponseStruct createItemTF(ResponseStruct question) {		
		Item item = new Item();
		
		item.setItemText(question.getItemText());
		item.setMarks(question.getMarks());
		item.setCgLvl(question.getCgLvl());
		item.setReviewStatus("PENDING");
		item.setItemUseCount(question.getItemUseCount());
		item.setItemStatus(question.getItemStatus());
		item.setDiffLvl(question.getDiffLvl());
		item.setAuthorId(question.getAuthorId());
		item.setItemType("TF");
		itemRepository.save(item);
		
		
		TF tf =new TF(question.getFalseMarks(),question.getTrueMarks());
		tf.setItemTF(item);
		item.getAsItemTF().add(tFRepository.save(tf));
		
		
		return question;
	}
	
	
	public ResponseStruct createItemMCQ(ResponseStruct question) {		
		Item item = new Item();
		
		item.setItemText(question.getItemText());
		item.setMarks(question.getMarks());
		item.setCgLvl(question.getCgLvl());
		item.setReviewStatus("PENDING");
		item.setItemUseCount(question.getItemUseCount());
		item.setItemStatus(question.getItemStatus());
		item.setDiffLvl(question.getDiffLvl());
		item.setAuthorId(question.getAuthorId());
		item.setItemType("MCQ");
		itemRepository.save(item);
		ArrayList<OptionsStruct> options=question.getOptions();
		for(int i=0;i<options.size();i++)
		{
			Options opt =new Options(options.get(i).opt,options.get(i).marks);
			opt.setItemMCQ(item);
			item.getAsItemMCQ().add(optRepository.save(opt));
		}
		
		return question;
	}
}
