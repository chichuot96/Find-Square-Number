package vn.topica.square.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vn.topica.square.utils.Obj;
import vn.topica.square.utils.Square;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.sqrt;

@Controller
public class MainController {

    @RequestMapping(value={"/","/*"},method= RequestMethod.GET)
    public String index(){
        return "index";
    }
    @RequestMapping(value={"/"}, method=RequestMethod.POST)
    public String findSquare(Model model, @RequestParam(name="number") String listNum){
        String[] arrNum=listNum.split(",");
        HashMap<Integer,Integer> mapNumber=new HashMap<>();
        for(int i=0;i<arrNum.length;i++){
            mapNumber.put(i,Integer.parseInt(arrNum[i]));
        }
        Square s=new Square();
        Map<Integer,Integer> mapSquare=mapNumber.entrySet().stream()
                .filter(entry->s.findOddSquare(entry.getValue()))
                .collect(Collectors.toMap(entry->entry.getKey(),entry->(int)sqrt(entry.getValue())));
//        mapSquare.entrySet().forEach(entry->{
//            System.out.println(entry.getKey()+"==="+entry.getValue());
//        });
        ArrayList<ArrayList<Obj>> listReturn=s.getSubArr(mapSquare);
        if(listReturn.size()==0){
            model.addAttribute("message","khong co day so thoa man");
            System.out.println("khong co");

        }
        model.addAttribute("mapNum",listReturn);
        model.addAttribute("listNum",listNum);
        return "index";
    }

}
