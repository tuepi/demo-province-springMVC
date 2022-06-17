package controller;

import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ProvinceService;
import service.impl.ProvinceServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/province/list");
        Iterable<Province> provinces = provinceService.findAll();
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(Province province) {
        return new ModelAndView("/province/create", "province", province);
    }

    @PostMapping("/create")
    public ModelAndView create(Province province) {
        provinceService.save(province);
        return new ModelAndView("redirect:/provinces");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        return new ModelAndView("/province/edit", "province", provinceService.findById(id));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        return new ModelAndView("/province/delete", "province", provinceService.findById(id));
    }

    @PostMapping("/delete")
    public ModelAndView delete(Province province) {
        provinceService.remove(province.getId());
        return new ModelAndView("redirect:/provinces");
    }
}
