package com.dashboard.dao;

import com.dashboard.model.Heroes;

import java.util.List;

public interface IHeroesData {
    public List<Heroes> ListHeroes();
    public List<Heroes> findByData(Heroes hero);
    public List<Heroes> comboPublisher();
    public List<Heroes> comboRace();
    public List<Heroes> comboAlignment();
    public String insert(Heroes hero);
    public String update(Heroes hero);
    public Heroes findByID(Integer heroid);
    public String delete (Heroes hero);
}
