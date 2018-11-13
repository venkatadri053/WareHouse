package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.app.model.Item;
import com.app.model.OrderMethod;
import com.app.model.Uom;
import com.app.model.WhUserType;
import com.app.service.IItemService;
import com.app.service.IOrderMethodService;
import com.app.service.IUomService;
import com.app.service.IWhUserTypeService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private IItemService service;

	@Autowired
	private IUomService uomservice;

	@Autowired
	private IOrderMethodService omService;

	@Autowired
	private IWhUserTypeService whUserService;

	// 1.Show Reg. form
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		map.addAttribute("item", new Item());

		List<Uom> uoms = uomservice.getAllUoms();
		map.addAttribute("uoms", uoms);

		List<OrderMethod> sales = omService.getOrderMethodByMode("sale");
		map.addAttribute("sales", sales);

		List<OrderMethod> purchase = omService.getOrderMethodByMode("purchase");
		map.addAttribute("purchase", purchase);

		List<WhUserType>vendors=whUserService.getWhUSerTypesByType("Vendor");
		map.addAttribute("vendors", vendors);

		List<WhUserType>customers=whUserService.getWhUSerTypesByType("Customer");
		map.addAttribute("customers",customers);

		return "ItemRegister";
	}

	// 2.Save data from DB
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveData(@ModelAttribute Item item, ModelMap map) {
		Integer id = service.saveItem(item);
		String msg = "Item '" + id + "' saved";
		map.addAttribute("message", msg);
		map.addAttribute("item", new Item());

		List<Uom> uoms = uomservice.getAllUoms();
		map.addAttribute("uoms", uoms);

		List<OrderMethod> sales = omService.getOrderMethodByMode("sale");
		map.addAttribute("sales", sales);

		List<OrderMethod> purchase = omService.getOrderMethodByMode("purchase");
		map.addAttribute("purchase", purchase);

		List<WhUserType>vendors=whUserService.getWhUSerTypesByType("Vendor");
		map.addAttribute("vendors", vendors);

		List<WhUserType>customers=whUserService.getWhUSerTypesByType("Customer");
		map.addAttribute("customers",customers);

		return "ItemRegister";
	}

	// 3 .Get data from DB to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<Item> items = service.getAllItems();
		map.addAttribute("list", items);
		return "ItemData";
	}

	// 4.Delete Item by Id
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("id") Integer id, ModelMap map) {
		service.deleteItem(id);
		String msg = "Item '" + id + "'Deleted";
		List<Item> items = service.getAllItems();
		map.addAttribute("message", msg);
		map.addAttribute("list", items);
		return "ItemData";
	}

	// 5. Edit Uom by Id
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer id, ModelMap map) {
		Item item = service.getOneItemById(id);
		map.addAttribute("item", item);

		List<Uom> uoms = uomservice.getAllUoms();
		map.addAttribute("uoms", uoms);

		List<OrderMethod> sales = omService.getOrderMethodByMode("sale");
		map.addAttribute("sales", sales);

		List<OrderMethod> purchase = omService.getOrderMethodByMode("purchase");
		map.addAttribute("purchase", purchase);

		List<WhUserType>vendors=whUserService.getWhUSerTypesByType("Vendor");
		map.addAttribute("vendors", vendors);

		List<WhUserType>customers=whUserService.getWhUSerTypesByType("Customer");
		map.addAttribute("customers",customers);

		return "ItemEdit";
	}

	// 6.Update Uom by Id
	@RequestMapping("/update")
	public String doUpdateUomData(@ModelAttribute Item item, ModelMap map) {
		service.updateItem(item);
		String msg = "Item '" + item.getId() + "'Updated Successfully";
		List<Item> items = service.getAllItems();
		map.addAttribute("message", msg);
		map.addAttribute("list", items);
		return "ItemData";
	}
}