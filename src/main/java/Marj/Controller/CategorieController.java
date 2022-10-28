package Marj.Controller;

import Marj.Model.Categorie.Categorie;
import entity.CategoryEntity;

import java.util.List;

public class CategorieController {

    Categorie categorie = new Categorie();

    public List<CategoryEntity>  getCategory() {

        return categorie.getAllCategories();
    }

}
