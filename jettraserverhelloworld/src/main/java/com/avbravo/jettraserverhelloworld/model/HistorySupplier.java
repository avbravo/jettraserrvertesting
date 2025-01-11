package com.avbravo.jettraserverhelloworld.model;
// <editor-fold defaultstate="collapsed" desc="imports">

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
/**
* Java
*/
import java.time.LocalDateTime;
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
import com.jmoordb.core.util.JmoordbCoreDateUtil;
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
import com.avbravo.jettraserverhelloworld.model.History;
import com.avbravo.jettraserverhelloworld.model.*;


// </editor-fold>
@RequestScoped
public class HistorySupplier  implements Serializable{
// <editor-fold defaultstate="collapsed" desc="inject">

    @Inject
   ActionHistorySupplier actionHistorySupplier ;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public History get(Supplier<? extendsHistory> s, Document document, Boolean... showError) ">

    public History get(Supplier<? extends History> s, Document document_, Boolean... showError) {
        History history= s.get(); 
            Boolean show = true;
        try {
            if (showError.length != 0) {
                show = showError[0];
            }
	
	 history.setIdhistory(document_.getLong("idhistory"));
	history.setDatabase(document_.getString("database"));
	history.setCollection(document_.getString("collection"));
	history.setIdcollection(document_.getString("idcollection"));

	// Embedded of [actionHistory]
	history.setActionHistory(actionHistorySupplier.get(ActionHistory::new,(Document) document_.get("actionHistory")));
		
	history.setData(document_.getString("data"));

         } catch (Exception e) {
             if (show) {
                MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
             }
         }
         return history;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public History getId(Supplier<? extendsHistory> s, Document document, Boolean... showError) ">

    public History getId(Supplier<? extends History> s, Document document_, Boolean... showError) {
        History history= s.get(); 
            Boolean show = true;
        try {
            if (showError.length != 0) {
                show = showError[0];
            }
	
	 history.setIdhistory(document_.getLong("idhistory"));

         } catch (Exception e) {
             if (show) {
                MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
             }
         }
         return history;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public History putObjectId(History history String _id, Boolean... showError) ">

    public History putObjectId(History history, String _id, Boolean... showError) {
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
         return history;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Document toDocument (History history) ">

    public Document toDocument(History history) {
        Document document_ = new Document();
        try {
	 
		document_.put("idhistory",history.getIdhistory());
		document_.put("database",history.getDatabase());
		document_.put("collection",history.getCollection());
		document_.put("idcollection",history.getIdcollection());

	// Embedded of actionHistory
		document_.put("actionHistory",actionHistorySupplier.toDocument(history.getActionHistory()));
		document_.put("data",history.getData());
	

         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return document_;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public List<Document> toDocument (List<History> historyList) ">

    public List<Document> toDocument(List<History> historyList) {
        List<Document> documentList_ = new ArrayList<>();
        try {
	 
	 for(History history : historyList){
		 Document document_ = new Document();
		document_.put("idhistory",history.getIdhistory());
		document_.put("database",history.getDatabase());
		document_.put("collection",history.getCollection());
		document_.put("idcollection",history.getIdcollection());

	// Embedded of actionHistory
		document_.put("actionHistory",actionHistorySupplier.toDocument(history.getActionHistory()));
		document_.put("data",history.getData());
		documentList_.add(document_);
	

       }
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return documentList_;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Bson toUpdate (History history) ">

    public Bson toUpdate(History history) {
        Bson update_ = Filters.empty();
        try {
        update_ = Updates.combine(
	 
		Updates.set("idhistory",history.getIdhistory()),
		Updates.set("database",history.getDatabase()),
		Updates.set("collection",history.getCollection()),
		Updates.set("idcollection",history.getIdcollection()),

	// Embedded of actionHistory
		Updates.set("actionHistory",actionHistorySupplier.toDocument(history.getActionHistory())),
		Updates.set("data",history.getData())
	

        );
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return update_;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public List<Bson> toUpdate (List<History> historyList) ">

    public List<Bson> toUpdate(List<History> historyList) {
        List<Bson> bsonList_ = new ArrayList<>();
        try {
	 for(History history : historyList){
		 Bson update_ = Filters.empty();
			update_ = Updates.combine(
	 
		Updates.set("idhistory",history.getIdhistory()),
		Updates.set("database",history.getDatabase()),
		Updates.set("collection",history.getCollection()),
		Updates.set("idcollection",history.getIdcollection()),

	// Embedded of actionHistory
		Updates.set("actionHistory",actionHistorySupplier.toDocument(history.getActionHistory())),
		Updates.set("data",history.getData())
	

        );
		bsonList_.add(update_);
 
       }
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return bsonList_;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public Document toReferenced (History history) ">

    public Document toReferenced(History history) {
        Document document_ = new Document();
        try {
	 
		document_.put("idhistory",history.getIdhistory());
	

         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return document_;
     }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc=" public List<Document> toReferenced(List<History> historyList) ">

    public List<Document> toReferenced(List<History> historyList) {
        List<Document> documentList_ = new ArrayList<>();
        try {
	 
	 for(History history : historyList){
		 Document document_ = new Document();
		document_.put("idhistory",history.getIdhistory());
		documentList_.add(document_);
	

       }
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return documentList_;
     }
// </editor-fold>

}