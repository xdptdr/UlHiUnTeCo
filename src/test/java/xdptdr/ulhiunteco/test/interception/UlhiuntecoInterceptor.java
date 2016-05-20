package xdptdr.ulhiunteco.test.interception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.EntityMode;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

import xdptdr.ulhiunteco.test.interception.events.CollectionEvent;
import xdptdr.ulhiunteco.test.interception.events.FlushEvent;
import xdptdr.ulhiunteco.test.interception.events.GetEntityEvent;
import xdptdr.ulhiunteco.test.interception.events.GetEntityNameEvent;
import xdptdr.ulhiunteco.test.interception.events.HibernateEvent;
import xdptdr.ulhiunteco.test.interception.events.InstantiationEvent;
import xdptdr.ulhiunteco.test.interception.events.IsTransientEvent;
import xdptdr.ulhiunteco.test.interception.events.PersistenceEvent;
import xdptdr.ulhiunteco.test.interception.events.SQLEvent;
import xdptdr.ulhiunteco.test.interception.events.TransactionEvent;

public class UlhiuntecoInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 1L;

	List<HibernateEvent> events = new ArrayList<>();

	@Override
	public String onPrepareStatement(String sql) {
		events.add(new SQLEvent(sql));
		return super.onPrepareStatement(sql);
	}

	@Override
	public void afterTransactionBegin(Transaction tx) {
		events.add(new TransactionEvent(TransactionEvent.TransactionEventType.AFTER_BEGIN, tx));
		super.afterTransactionBegin(tx);
	}

	@Override
	public void beforeTransactionCompletion(Transaction tx) {
		events.add(new TransactionEvent(TransactionEvent.TransactionEventType.BEFORE_COMPLETION, tx));
		super.beforeTransactionCompletion(tx);
	}

	@Override
	public void afterTransactionCompletion(Transaction tx) {
		events.add(new TransactionEvent(TransactionEvent.TransactionEventType.AFTER_COMPLETION, tx));
		super.afterTransactionCompletion(tx);
	}

	@Override
	public Object getEntity(String entityName, Serializable id) {
		Object result = super.getEntity(entityName, id);
		events.add(new GetEntityEvent(entityName, id, result));
		return result;
	}

	@Override
	public int[] findDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		int[] result = super.findDirty(entity, id, currentState, previousState, propertyNames, types);
		events.add(new PersistenceEvent(PersistenceEvent.PersistenceEventType.FIND_DIRTY, entity, id, currentState,
				previousState, propertyNames, types, result));
		return result;
	}

	@Override
	public String getEntityName(Object object) {
		String result = super.getEntityName(object);
		events.add(new GetEntityNameEvent(object, result));
		return result;
	}

	@Override
	public Object instantiate(String entityName, EntityMode entityMode, Serializable id) {
		Object result = super.instantiate(entityName, entityMode, id);
		events.add(new InstantiationEvent(entityName, entityMode, id, result));
		return result;
	}

	@Override
	public Boolean isTransient(Object entity) {
		events.add(new IsTransientEvent(entity));
		return super.isTransient(entity);
	}

	@Override
	public void onCollectionRecreate(Object collection, Serializable key) throws CallbackException {
		events.add(new CollectionEvent(CollectionEvent.CollectionEventType.RECREATE, collection, key));
		super.onCollectionRecreate(collection, key);
	}

	@Override
	public void onCollectionRemove(Object collection, Serializable key) throws CallbackException {
		events.add(new CollectionEvent(CollectionEvent.CollectionEventType.REMOVE, collection, key));
		super.onCollectionRemove(collection, key);
	}

	@Override
	public void onCollectionUpdate(Object collection, Serializable key) throws CallbackException {
		events.add(new CollectionEvent(CollectionEvent.CollectionEventType.UPDATE, collection, key));
		super.onCollectionUpdate(collection, key);
	}

	@Override
	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		events.add(new PersistenceEvent(PersistenceEvent.PersistenceEventType.DELETE, entity, id, state, null,
				propertyNames, types, null));
		super.onDelete(entity, id, state, propertyNames, types);
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		boolean result = super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
		events.add(new PersistenceEvent(PersistenceEvent.PersistenceEventType.FLUSH_DIRTY, entity, id, currentState,
				previousState, propertyNames, types, null));
		return result;
	}

	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		boolean result = super.onLoad(entity, id, state, propertyNames, types);
		events.add(new PersistenceEvent(PersistenceEvent.PersistenceEventType.LOAD, entity, id, state, null,
				propertyNames, types, null));
		return result;
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		boolean result = super.onSave(entity, id, state, propertyNames, types);
		events.add(new PersistenceEvent(PersistenceEvent.PersistenceEventType.SAVE, entity, id, state, null,
				propertyNames, types, null));
		return result;
	}

	@Override
	public void postFlush(@SuppressWarnings("rawtypes") Iterator entities) {
		events.add(new FlushEvent(FlushEvent.FlushEventType.POST, entities));
		super.postFlush(entities);
	}

	@Override
	public void preFlush(@SuppressWarnings("rawtypes") Iterator entities) {
		events.add(new FlushEvent(FlushEvent.FlushEventType.PRE, entities));
		super.preFlush(entities);
	}

	public List<HibernateEvent> getEvents() {
		return Collections.unmodifiableList(events);
	}

}