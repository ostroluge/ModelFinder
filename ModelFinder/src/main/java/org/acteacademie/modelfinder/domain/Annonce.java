package org.acteacademie.modelfinder.domain;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.acteacademie.modelfinder.enums.CategoriesEnum;
import org.acteacademie.modelfinder.enums.EyeColorEnum;
import org.acteacademie.modelfinder.enums.LengthHairEnum;
import org.acteacademie.modelfinder.enums.SkinToneEnum;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

	@Entity
	@Table(name="ANNONCE")
	public class Annonce{
		
		@Id
		@Column(name="ID_ANNONCE")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long id;
		
		@Column(name="ETUDIANT_ID", unique = false, nullable = false)
		private long idStudent;
		
		@Column(name="GROUPE_ACCESSOIRE_ID", unique= true, nullable = true)
		private long accessories;
		
		@Column(name="TITRE", unique = false, nullable = false)
		private String title;

		@Column(name="CATEGORIE_PRESTATION", unique = false, nullable = false)
		@Enumerated(EnumType.STRING)
		private CategoriesEnum categoryService;
		
		@Column(name="THEME_PRESTATION", unique = false, nullable = false)
		private String themeService;
		
		@Column(name="CARNATION_PEAU", unique = false, nullable = false)
		@Enumerated(EnumType.STRING)
		private SkinToneEnum skinTone;

		@Column(name="COULEUR_CHEVEUX", unique = false, nullable = false)
		private String hairColor;
		
		@Column(name="COULEUR_YEUX", unique = false, nullable = false)
		@Enumerated(EnumType.STRING)
		private EyeColorEnum eyeColor;
		
		@Column(name="LONGUEUR_CHEVEUX", unique = false, nullable = false)
		@Enumerated(EnumType.STRING)
		private LengthHairEnum lengthHair;
		
		@Column(name="TAILLE_MODELE_MIN", unique = false, nullable = false)
		private int heightMin;
		
		@Column(name="TAILLE_MODELE_MAX", unique = false, nullable = false)
		private int heightMax;
		
		@Column(name="DATE_DEBUT", unique = false, nullable = false)
		private Date dateBegin;

		@Column(name="DUREE", unique = false, nullable = false)
		private Time duration;
		
		@Column(name="COMMENTAIRE", unique = false, nullable = false)
		private String comment;

		protected Annonce(){}
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public long getIdStudent() {
			return idStudent;
		}

		public void setIdStudent(long idStudent) {
			this.idStudent = idStudent;
		}

		public long getAccessories() {
			return accessories;
		}

		public void setAccessories(long accessories) {
			this.accessories = accessories;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public CategoriesEnum getCategoryService() {
			return categoryService;
		}
		
		public void setCategoryService(CategoriesEnum categoryService) {
			this.categoryService = categoryService;
		}

		public String getThemeService() {
			return themeService;
		}

		public void setThemeService(String themeService) {
			this.themeService = themeService;
		}

		public SkinToneEnum getSkinTone() {
			return skinTone;
		}

		public void setSkinTone(SkinToneEnum skinTone) {
			this.skinTone = skinTone;
		}

		public String getHairColor() {
			return hairColor;
		}

		public void setHairColor(String hairColor) {
			this.hairColor = hairColor;
		}

		public EyeColorEnum getEyeColor() {
			return eyeColor;
		}

		public void setEyeColor(EyeColorEnum eyeColor) {
			this.eyeColor = eyeColor;
		}

		public LengthHairEnum getLengthHair() {
			return lengthHair;
		}

		public void setLengthHair(LengthHairEnum lengthHair) {
			this.lengthHair = lengthHair;
		}

		public int getHeightMin() {
			return heightMin;
		}

		public void setHeightMin(int heightMin) {
			this.heightMin = heightMin;
		}

		public int getHeightMax() {
			return heightMax;
		}

		public void setHeightMax(int heightMax) {
			this.heightMax = heightMax;
		}

		public Date getDateBegin() {
			return dateBegin;
		}

		public void setDateBegin(Date dateBegin) {
			this.dateBegin = dateBegin;
		}

		public Time getDuration() {
			return duration;
		}

		public void setDuration(Time duration) {
			this.duration = duration;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		@Override
		public String toString() {
			return "Annonce [id=" + id + ", id_etudiant=" + idStudent + ", id_accessoires=" + accessories
					+ ", titre=" + title + ", categorie_prestation=" + categoryService + ", theme_prestation="
					+ themeService + ", carnation_peau=" + skinTone + ", couleur_cheveux=" + hairColor
					+ ", couleur_yeux=" + eyeColor + ", longueur_cheveux=" + lengthHair
					+ ", taille_modele_min=" + heightMin + ", taille_modele_max=" + heightMax
					+ ", date_debut=" + dateBegin + ", duree=" + duration + ", commentaire=" + comment + "]";
		}
}