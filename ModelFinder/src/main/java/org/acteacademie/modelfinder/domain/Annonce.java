package org.acteacademie.modelfinder.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="ANNONCE")
	public class Annonce{
		
		@Id
		@Column(name="ID_ANNONCE")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long id;
		
		@Column(name="ETUDIANT_ID", unique = false, nullable = false)
		private long id_etudiant;
		
		@Column(name="GROUPE_ACCESSOIRE_ID", unique = true, nullable = false)
		private long id_accessoires;
		
		@Column(name="TITRE", unique = false, nullable = false)
		private String titre;

		@Column(name="CATEGORIE_PRESTATION", unique = false, nullable = false)
		private String categorie_prestation;
		
		@Column(name="THEME_PRESTATION", unique = false, nullable = false)
		private String theme_prestation;
		
		@Column(name="CARNATION_PEAU", unique = false, nullable = false)
		private String carnation_peau;

		@Column(name="COULEUR_CHEVEUX", unique = false, nullable = false)
		private String couleur_cheveux;
		
		@Column(name="COULEUR_YEUX", unique = false, nullable = false)
		private String couleur_yeux;
		
		@Column(name="LONGUEUR_CHEVEUX", unique = false, nullable = false)
		private String longueur_cheveux;
		
		@Column(name="TAILLE_MODELE_MIN", unique = false, nullable = false)
		private int taille_modele_min;
		
		@Column(name="TAILLE_MODELE_MAX", unique = false, nullable = false)
		private int taille_modele_max;
		
		@Column(name="DATE_DEBUT", unique = false, nullable = false)
		private Date date_debut;

		@Column(name="DATE_FIN", unique = false, nullable = false)
		private Date date_fin;
		
		@Column(name="COMMENTAIRE", unique = false, nullable = false)
		private String commentaire;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public long getId_etudiant() {
			return id_etudiant;
		}

		public void setId_etudiant(long id_etudiant) {
			this.id_etudiant = id_etudiant;
		}

		public long getId_accessoires() {
			return id_accessoires;
		}

		public void setId_accessoires(long id_accessoires) {
			this.id_accessoires = id_accessoires;
		}

		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		public String getCategorie_prestation() {
			return categorie_prestation;
		}

		public void setCategorie_prestation(String categorie_prestation) {
			this.categorie_prestation = categorie_prestation;
		}

		public String getTheme_prestation() {
			return theme_prestation;
		}

		public void setTheme_prestation(String theme_prestation) {
			this.theme_prestation = theme_prestation;
		}

		public String getCarnation_peau() {
			return carnation_peau;
		}

		public void setCarnation_peau(String carnation_peau) {
			this.carnation_peau = carnation_peau;
		}

		public String getCouleur_cheveux() {
			return couleur_cheveux;
		}

		public void setCouleur_cheveux(String couleur_cheveux) {
			this.couleur_cheveux = couleur_cheveux;
		}

		public String getCouleur_yeux() {
			return couleur_yeux;
		}

		public void setCouleur_yeux(String couleur_yeux) {
			this.couleur_yeux = couleur_yeux;
		}

		public String getLongueur_cheveux() {
			return longueur_cheveux;
		}

		public void setLongueur_cheveux(String longueur_cheveux) {
			this.longueur_cheveux = longueur_cheveux;
		}

		public int getTaille_modele_min() {
			return taille_modele_min;
		}

		public void setTaille_modele_min(int taille_modele_min) {
			this.taille_modele_min = taille_modele_min;
		}

		public int getTaille_modele_max() {
			return taille_modele_max;
		}

		public void setTaille_modele_max(int taille_modele_max) {
			this.taille_modele_max = taille_modele_max;
		}

		public Date getDate_debut() {
			return date_debut;
		}

		public void setDate_debut(Date date_debut) {
			this.date_debut = date_debut;
		}

		public Date getDate_fin() {
			return date_fin;
		}

		public void setDate_fin(Date date_fin) {
			this.date_fin = date_fin;
		}

		public String getCommentaire() {
			return commentaire;
		}

		public void setCommentaire(String commentaire) {
			this.commentaire = commentaire;
		}

		@Override
		public String toString() {
			return "Annonce [id=" + id + ", id_etudiant=" + id_etudiant + ", id_accessoires=" + id_accessoires
					+ ", titre=" + titre + ", categorie_prestation=" + categorie_prestation + ", theme_prestation="
					+ theme_prestation + ", carnation_peau=" + carnation_peau + ", couleur_cheveux=" + couleur_cheveux
					+ ", couleur_yeux=" + couleur_yeux + ", longueur_cheveux=" + longueur_cheveux
					+ ", taille_modele_min=" + taille_modele_min + ", taille_modele_max=" + taille_modele_max
					+ ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", commentaire=" + commentaire + "]";
		}

	
	
}