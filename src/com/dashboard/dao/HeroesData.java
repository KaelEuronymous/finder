package com.dashboard.dao;

import com.dashboard.connection.DBConnection;
import com.dashboard.model.Heroes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HeroesData implements IHeroesData {

    @Override
    public List<Heroes> ListHeroes() {

        List<Heroes> listhero = new ArrayList<>();
        ResultSet rs;

        try{
            DBConnection letsconnect = new DBConnection();
            System.out.println(letsconnect);

            String sql = "SELECT h.hero_id, h.name, p.publisher_name, h.race, a.name as alignment FROM hero_information as h INNER JOIN publisher as p ON (h.publisher_id=p.publisher_id) INNER JOIN alignment as a ON (h.alignment_id=a.alignment_id)";

            PreparedStatement ps = letsconnect.getConnection().prepareCall(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Heroes hero = new Heroes();
                hero.setHeroid(rs.getInt("hero_id"));
                hero.setHeroname(rs.getString("name"));
                hero.setPublishername(rs.getString("publisher_name"));
                hero.setRace(rs.getString("race"));
                hero.setAlignmentname(rs.getString("alignment"));
                listhero.add(hero);
            }
            letsconnect.DBDisconnect();

        } catch (SQLException e) {
            System.out.println("Error while showing heroes"+e.getMessage());
        }

        return listhero;
    }

    //Load data from heroes db, bringing: publiser_id, race and alignment_id.
    @Override
    public List findByData(Integer pubid, Integer alid, String race) {
        List<Heroes> listhero = new ArrayList<>();

        try{
            DBConnection letsconnect = new DBConnection();

            String sql = "SELECT h.hero_id, h.name, p.publisher_name, h.race, a.name as alignment FROM hero_information as h INNER JOIN publisher as p ON (h.publisher_id=p.publisher_id) INNER JOIN alignment as a ON (h.alignment_id=a.alignment_id) WHERE a.alignment_id = ? AND p.publisher_id = ? AND h.race = ?";

            PreparedStatement ps = letsconnect.getConnection().prepareStatement(sql);
            ps.setInt(1, alid);
            ps.setInt(2, pubid);
            ps.setString(3, race);
            ResultSet rs = ps.executeQuery();
            System.out.println(pubid+"alo"+alid+"ola"+race);
            while (rs.next()){
                Heroes hero = new Heroes();

                hero.setHeroid(rs.getInt("hero_id"));
                hero.setHeroname(rs.getString("name"));
                hero.setPublishername(rs.getString("publisher_name"));
                hero.setRace(rs.getString("race"));
                hero.setAlignmentname(rs.getString("alignment"));

                listhero.add(hero);
            }
            letsconnect.DBDisconnect();

        } catch (SQLException e) {
            System.out.println("Error while showing heroes"+e.getMessage());
        }
        return listhero;
    }

    //insert new data
    @Override
    public String insert(Heroes hero) {
        String message;
        System.out.println(hero.getHeroid()+hero.getHeroname()+hero.getRace());
        try {
            DBConnection letsconnect = new DBConnection();
            String sql = "INSERT INTO hero_information (hero_id, name, eye_color, hair_color, skin_color, height, weight, race, publisher_id, gender_id, alignment_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            System.out.println(sql);

            PreparedStatement ps = letsconnect.getConnection().prepareCall(sql);


            ps.setInt(1, hero.getHeroid());
            ps.setString(2, hero.getHeroname());
            ps.setString(3, hero.getEyecolor());
            ps.setString(4, hero.getHaircolor());
            ps.setString(5, hero.getSkincolor());
            ps.setInt(6, hero.getHeight());
            ps.setInt(7, hero.getWeight());
            ps.setString(8, hero.getRace());
            ps.setInt(9, hero.getPublisherid());
            ps.setInt(10, hero.getGenderid());
            ps.setInt(11, hero.getAlignmentid());
            ps.executeUpdate();
            message="Hero has been added successfuly";
            letsconnect.DBDisconnect();
            System.out.println(message);

        } catch (SQLException e) {
            e.printStackTrace();
            message="Hero can not be Added, verify data.";
        }
        return message;
    }





    //update data
    @Override
    public String update(Heroes hero){
        String message;
        try{
            DBConnection letsconnect = new DBConnection();
            String sql = "UPDATE hero_information SET name=?, eye_color=?, hair_color=?, skin_color=?, height=?, weight=?, race=?, publisher_id=?, gender_id=?, alignment_id=? WHERE hero_id=?";

            PreparedStatement ps = letsconnect.getConnection().prepareCall(sql);

            ps.setString(1, hero.getHeroname());
            ps.setString(2, hero.getEyecolor());
            ps.setString(3, hero.getHaircolor());
            ps.setString(4, hero.getSkincolor());
            ps.setInt(5, hero.getHeight());
            ps.setInt(6, hero.getWeight());
            ps.setString(7, hero.getRace());
            ps.setInt(8, hero.getPublisherid());
            ps.setInt(9, hero.getGenderid());
            ps.setInt(10, hero.getAlignmentid());
            ps.setInt(11, hero.getHeroid());
            ps.executeUpdate();
            message="Hero updated successfuly";
            letsconnect.DBDisconnect();

        }catch (SQLException e){
            e.printStackTrace();
            message="Hero can not be updated, verify data.";
        }
        return message;
    }

    @Override
    public Heroes findByID(Integer heroid) {
        Heroes hero = null;

        try {
            DBConnection letsconnect = new DBConnection();
            String sql = "SELECT * FROM hero_information WHERE hero_id=? LIMIT 1";
            PreparedStatement ps = letsconnect.getConnection().prepareStatement(sql);
            ps.setLong(1, heroid);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                hero = new Heroes();
                hero.setHeroid(rs.getInt("hero_id"));
                hero.setHeroname(rs.getString("name"));
                hero.setEyecolor(rs.getString("eye_color"));
                hero.setHaircolor(rs.getString("hair_color"));
                hero.setSkincolor(rs.getString("skin_color"));
                hero.setHeight(rs.getInt("height"));
                hero.setWeight(rs.getInt("weight"));

                System.out.println(rs);
            }
            letsconnect.DBDisconnect();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return hero;
    }


    //find data from id


    //delete data from id
    @Override
    public String delete(Heroes hero) {
        String message ="";

        try{
            DBConnection letsconnect = new DBConnection();
            String sql = "delete from hero_information where hero_id=?";

            PreparedStatement ps = letsconnect.getConnection().prepareCall(sql);
            ps.setInt(1,hero.getHeroid());

            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            message ="Error deleting Hero";
        }
        return message;
    }


    //fill combo with publisher_id and publisher_name
    @Override
    public List<Heroes> comboPublisher() {
        Heroes heropub;
        List<Heroes> listhero = new ArrayList<>();
        ResultSet rs;

        try{
            DBConnection letsconnect = new DBConnection();
            System.out.println(letsconnect);

            String sql = "SELECT publisher_id, publisher_name FROM publisher";

            PreparedStatement ps = letsconnect.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                heropub = new Heroes();
                heropub.setPublisherid(rs.getInt("publisher_id"));
                heropub.setPublishername(rs.getString("publisher_name"));
                listhero.add(heropub);

                //System.out.println(rs);
            }
            letsconnect.DBDisconnect();

        } catch (SQLException e) {
            System.out.println("Error while showing heroes"+e.getMessage());
        }

        return listhero;
    }

    @Override
    public List<Heroes> comboRace() {
        Heroes herorace;
        List<Heroes> listhero = new ArrayList<>();
        ResultSet rs;

        try{
            DBConnection letsconnect = new DBConnection();
            System.out.println(letsconnect);

            String sql = "SELECT DISTINCT race FROM hero_information where race is not null ORDER BY race ASC";

            PreparedStatement ps = letsconnect.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                herorace = new Heroes();
                herorace.setRace(rs.getString("race"));
                listhero.add(herorace);

                //System.out.println(rs);
            }
            letsconnect.DBDisconnect();

        } catch (SQLException e) {
            System.out.println("Error while showing heroes"+e.getMessage());
        }

        return listhero;

    }
    @Override
    public List<Heroes> comboAlignment() {
        Heroes heroali;
        List<Heroes> listhero = new ArrayList<>();
        ResultSet rs;

        try{
            DBConnection letsconnect = new DBConnection();
            System.out.println(letsconnect);

            String sql = "SELECT alignment_id, name FROM alignment";

            PreparedStatement ps = letsconnect.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                heroali = new Heroes();
                heroali.setAlignmentid(rs.getInt("alignment_id"));
                heroali.setAlignmentname(rs.getString("name"));
                listhero.add(heroali);

                //System.out.println(rs);
            }
            letsconnect.DBDisconnect();

        } catch (SQLException e) {
            System.out.println("Error while showing heroes"+e.getMessage());
        }

        return listhero;
    }


}
