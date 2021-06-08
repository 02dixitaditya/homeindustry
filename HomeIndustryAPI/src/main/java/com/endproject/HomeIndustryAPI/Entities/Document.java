package com.endproject.HomeIndustryAPI.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="document")
public class Document {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @Column(name="user_id", nullable=false)
   private String userId;

   @Column(name="document_category")
   private String documentCategory;
  
   @Column(name="document_name")
   private String documentName;
 
   @Lob
   private byte[] image;

   
   
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getDocumentCategory() {
		return documentCategory;
	}
	
	public void setDocumentCategory(String documentCategory) {
		this.documentCategory = documentCategory;
	}
	
	public String getDocumentName() {
		return documentName;
	}
	
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
	public Document() {
		super();
	}
	
	public Document(int id, String userId, String documentCategory, String documentName, byte[] image) {
		super();
		this.id = id;
		this.userId = userId;
		this.documentCategory = documentCategory;
		this.documentName = documentName;
		this.image = image;
	}

}
