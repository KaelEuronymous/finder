package com.dashboard;
import com.dashboard.dao.HeroesData;
import com.dashboard.model.Heroes;
import java.util.List;


public class Tester {
    public static void main(String[] args) {
/*
        HeroesData data = new HeroesData();
        List<Heroes> listheroes = (List<Heroes>) data.findByData();

        for (Heroes heroes : listheroes){
            System.out.print(heroes.getHeroid()+"-");
            System.out.print(heroes.getHeroname()+"-");
            System.out.print(heroes.getPublishername()+"-");
            System.out.println(heroes.getRace());
        }
*/
        /*
        HeroesData data = new HeroesData();
        List<Heroes> listapublish = data.comboPublisher();
        for (Heroes heroes : listapublish){
            System.out.print(heroes.getPublisherid()+"-");
            System.out.println(heroes.getPublishername()+"-");
        }*/

        HeroesData list = new HeroesData();
        List<Heroes> hero = list.findByData( 12,  1, "Human");

        for (Heroes heroes : hero){
            System.out.print(heroes.getHeroname()+"-");
            System.out.println(heroes.getRace()+"-");
        }


    }
}
