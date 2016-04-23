package org.acteacademie.modelfinder.domain;
import javax.persistence.*;


@Entity
@Table(name="R_RESPONSE")
public class Response{

		@Id
		@Column(name="REPONSE_ID")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long id;
	
		@ManyToOne
	    @JoinColumn(name = "ANNONCE_ID")
		private Annonce Annonce;
		
		@ManyToOne
	    @JoinColumn(name = "MODELE_ID")
		private Model Model;
		
		@Column(name="STATUS_ACCESSORY_1", unique = false, nullable = true)
		private String StatusAccessory1;
		
		@Column(name="STATUS_ACCESSORY_2", unique = false, nullable = true)
		private String StatusAccessory2;
		
		@Column(name="STATUS_ACCESSORY_3", unique = false, nullable = true)
		private String StatusAccessory3;
		
		@Column(name="STATUS_ACCESSORY_4", unique = false, nullable = true)
		private String StatusAccessory4;
		
		@Column(name="STATUS_ACCESSORY_5", unique = false, nullable = true)
		private String StatusAccessory5;
		
		@Column(name="RESPONSE_STATUS", unique = false, nullable = false)
		private String Statut;

		@Column(name="COMMENT", unique = false, nullable = true)
		private String Comment;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Annonce getAnnonce() {
			return Annonce;
		}

		public void setAnnonce(Annonce annonce) {
			Annonce = annonce;
		}

		public Model getModel() {
			return Model;
		}

		public void setModel(Model model) {
			Model = model;
		}

		public String getStatusAccessory1() {
			return StatusAccessory1;
		}

		public void setStatusAccessory1(String statusAccessory1) {
			StatusAccessory1 = statusAccessory1;
		}

		public String getStatusAccessory2() {
			return StatusAccessory2;
		}

		public void setStatusAccessory2(String statusAccessory2) {
			StatusAccessory2 = statusAccessory2;
		}

		public String getStatusAccessory3() {
			return StatusAccessory3;
		}

		public void setStatusAccessory3(String statusAccessory3) {
			StatusAccessory3 = statusAccessory3;
		}

		public String getStatusAccessory4() {
			return StatusAccessory4;
		}

		public void setStatusAccessory4(String statusAccessory4) {
			StatusAccessory4 = statusAccessory4;
		}

		public String getStatusAccessory5() {
			return StatusAccessory5;
		}

		public void setStatusAccessory5(String statusAccessory5) {
			StatusAccessory5 = statusAccessory5;
		}

		public String getStatut() {
			return Statut;
		}

		public void setStatut(String statut) {
			Statut = statut;
		}

		public String getComment() {
			return Comment;
		}

		public void setComment(String comment) {
			Comment = comment;
		}

		@Override
		public String toString() {
			return "Reponse [id=" + id + ", Annonce=" + Annonce + ", Model=" + Model + ", StatusAccessory1="
					+ StatusAccessory1 + ", StatusAccessory2=" + StatusAccessory2 + ", StatusAccessory3="
					+ StatusAccessory3 + ", StatusAccessory4=" + StatusAccessory4 + ", StatusAccessory5="
					+ StatusAccessory5 + ", Statut=" + Statut + ", Comment=" + Comment + "]";
		}

}