package com.oda.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.oda.domain.Category;

/**
 *
 * @author rodrigooda
 */
public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotNull
    private String code;
    @NotNull
    private boolean status;

    public CategoryDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Category toEntity() {
    	Category category = new Category();
    	if(this.id != null) {
    		category.setId(this.id);
    	} else {
    		category.setStatus(true);
    	}
    	category.setStatus(this.status);
		category.setCode(code);
		return category;
    }
}
