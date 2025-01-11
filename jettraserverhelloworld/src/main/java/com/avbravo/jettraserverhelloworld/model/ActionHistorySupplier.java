package com.avbravo.jettraserverhelloworld.model;
// <editor-fold defaultstate="collapsed" desc="imports">

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
/**
* Java
*/
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.UUID;
/**
* Jmoordb
*/
import com.jmoordb.core.util.MessagesUtil;
import java.util.UUID;
import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.TypePK;
import com.jmoordb.core.annotation.enumerations.TypeReferenced;
/**
* MongoDB
*/
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.conversions.Bson;
import com.avbravo.jettraserverhelloworld.model.ActionHistory;
import com.avbravo.jettraserverhelloworld.model.*;


// </editor-fold>
@RequestScoped
public class ActionHistorySupplier  implements Serializable{
// <editor-fold defaultstate="collapsed" desc=" public ActionHistory get(Supplier<? extendsActionHistory> s, Document document, Boolean... showError) ">

    public ActionHistory get(Supplier<? extends ActionHistory> s, Document document_, Boolean... showError) {
        ActionHistory actionHistory= s.get(); 
            Boolean show = true;
        try {
            if (showError.length != 0) {
                show = showError[0];
            }
		actionHistory.setFecha(document_.getDate("fecha"));
	actionHistory.setIduser(document_.getLong("iduser"));
	actionHistory.setEvento(document_.getString("evento"));
	actionHistory.setClase(document_.getString("clase"));
	actionHistory.setMetodo(document_.getString("metodo"));

         } catch (Exception e) {
             if (show) {
                MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
             }
         }
         return actionHistory;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public ActionHistory get(Supplier<? extendsActionHistory> s, Document document, Boolean... showError) ">

    public ActionHistory getId(Supplier<? extends ActionHistory> s, Document document_, Boolean... showError) {
        ActionHistory actionHistory= s.get(); 
            Boolean show = true;
        try {
            if (showError.length != 0) {
                show = showError[0];
            }
	
         } catch (Exception e) {
             if (show) {
                MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
             }
         }
         return actionHistory;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Document toDocument (ActionHistory actionHistory) ">

    public Document toDocument(ActionHistory actionHistory) {
        Document document_ = new Document();
        try {
	 		document_.put("fecha",actionHistory.getFecha());
		document_.put("iduser",actionHistory.getIduser());
		document_.put("evento",actionHistory.getEvento());
		document_.put("clase",actionHistory.getClase());
		document_.put("metodo",actionHistory.getMetodo());
	

         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return document_;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public List<Document> toDocument (List<ActionHistory> actionHistoryList) ">

    public List<Document> toDocument(List<ActionHistory> actionHistoryList) {
        List<Document> documentList_ = new ArrayList<>();
        try {
	 
	 for(ActionHistory actionHistory : actionHistoryList){
		 Document document_ = new Document();
		document_.put("fecha",actionHistory.getFecha());
		document_.put("iduser",actionHistory.getIduser());
		document_.put("evento",actionHistory.getEvento());
		document_.put("clase",actionHistory.getClase());
		document_.put("metodo",actionHistory.getMetodo());
		documentList_.add(document_);
	

       }
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return documentList_;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Bson toUpdate (ActionHistory actionHistory) ">

    public Bson toUpdate(ActionHistory actionHistory) {
       Bson update_ = Filters.empty();
        try {
        update_ = Updates.combine(
	 
		Updates.set("fecha",actionHistory.getFecha()),
		Updates.set("iduser",actionHistory.getIduser()),
		Updates.set("evento",actionHistory.getEvento()),
		Updates.set("clase",actionHistory.getClase()),
		Updates.set("metodo",actionHistory.getMetodo())
	

        );
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return update_;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public List<Bson> toUpdate (List<ActionHistory> actionHistoryList) ">

    public List<Bson> toUpdate(List<ActionHistory> actionHistoryList) {
        List<Bson> bsonList_ = new ArrayList<>();
        try {
	 for(ActionHistory actionHistory : actionHistoryList){
		 Bson update_ = Filters.empty();
			update_ = Updates.combine(
	 
		Updates.set("fecha",actionHistory.getFecha()),
		Updates.set("iduser",actionHistory.getIduser()),
		Updates.set("evento",actionHistory.getEvento()),
		Updates.set("clase",actionHistory.getClase()),
		Updates.set("metodo",actionHistory.getMetodo())
	

        );
		bsonList_.add(update_);
 
       }
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return bsonList_;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Document toReferenced (ActionHistory actionHistory) ">

    public Document toReferenced(ActionHistory actionHistory) {
        Document document_ = new Document();
        try {
	 	

         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return document_;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public List<Document> toReferenced (List<ActionHistory> actionHistoryList) ">

    public List<Document> toReferenced(List<ActionHistory> actionHistoryList) {
        List<Document> documentList_ = new ArrayList<>();
        try {
	 
	 for(ActionHistory actionHistory : actionHistoryList){
		 Document document_ = new Document();
		documentList_.add(document_);
	

       }
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return documentList_;
     }
// </editor-fold>

}