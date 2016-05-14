package xdptdr.ulhiunteco.an;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import xdptdr.ulhiunteco.aa.TestAA;
import xdptdr.ulhiunteco.ab.TestAB;
import xdptdr.ulhiunteco.test.AbstractTest;

/**
 * @author xdptdr
 */

public class TestAN extends AbstractTest {

	public TestAN() {
		super(new Class<?>[] { ClassAN.class });
	}

	@Test
	public void testCreate() {

		Class<?>[] classes = new Class<?>[] { Access.class, AccessType.class, AssociationOverride.class,
				AssociationOverrides.class, AttributeConverter.class, AttributeNode.class, AttributeOverride.class,
				AttributeOverrides.class, Basic.class, Cache.class, Cacheable.class, CacheRetrieveMode.class,
				CacheStoreMode.class, CascadeType.class, CollectionTable.class, Column.class, ColumnResult.class,
				ConstraintMode.class, ConstructorResult.class, Convert.class, Converter.class, Converts.class,
				DiscriminatorColumn.class, DiscriminatorType.class, DiscriminatorValue.class, ElementCollection.class,
				Embeddable.class, Embedded.class, EmbeddedId.class, Entity.class, EntityExistsException.class,
				EntityGraph.class, EntityListeners.class, EntityManager.class, EntityManagerFactory.class,
				EntityNotFoundException.class, EntityResult.class, EntityTransaction.class, Enumerated.class,
				EnumType.class, ExcludeDefaultListeners.class, ExcludeSuperclassListeners.class, FetchType.class,
				FieldResult.class, FlushModeType.class, ForeignKey.class, GeneratedValue.class, GenerationType.class,
				Id.class, IdClass.class, Index.class, Inheritance.class, InheritanceType.class, JoinColumn.class,
				JoinColumns.class, JoinTable.class, Lob.class, LockModeType.class, LockTimeoutException.class,
				ManyToMany.class, ManyToOne.class, MapKey.class, MapKeyClass.class, MapKeyColumn.class,
				MapKeyEnumerated.class, MapKeyJoinColumn.class, MapKeyJoinColumns.class, MapKeyTemporal.class,
				MappedSuperclass.class, MapsId.class, NamedAttributeNode.class, NamedEntityGraph.class,
				NamedEntityGraphs.class, NamedNativeQueries.class, NamedNativeQuery.class, NamedQueries.class,
				NamedQuery.class, NamedStoredProcedureQueries.class, NamedStoredProcedureQuery.class,
				NamedSubgraph.class, NonUniqueResultException.class, NoResultException.class, OneToMany.class,
				OneToOne.class, OptimisticLockException.class, OrderBy.class, OrderColumn.class, Parameter.class,
				ParameterMode.class, Persistence.class, PersistenceContext.class, PersistenceContexts.class,
				PersistenceContextType.class, PersistenceException.class, PersistenceProperty.class,
				PersistenceUnit.class, PersistenceUnits.class, PersistenceUnitUtil.class, PersistenceUtil.class,
				PessimisticLockException.class, PessimisticLockScope.class, PostLoad.class, PostPersist.class,
				PostRemove.class, PostUpdate.class, PrePersist.class, PreRemove.class, PreUpdate.class,
				PrimaryKeyJoinColumn.class, PrimaryKeyJoinColumns.class, Query.class, QueryHint.class,
				QueryTimeoutException.class, RollbackException.class, SecondaryTable.class, SecondaryTables.class,
				SequenceGenerator.class, SharedCacheMode.class, SqlResultSetMapping.class, SqlResultSetMappings.class,
				StoredProcedureParameter.class, StoredProcedureQuery.class, Subgraph.class, SynchronizationType.class,
				Table.class, TableGenerator.class, Temporal.class, TemporalType.class,
				TransactionRequiredException.class, Transient.class, Tuple.class, TupleElement.class, TypedQuery.class,
				UniqueConstraint.class, ValidationMode.class, Version.class };

		Map<String, ClassAN> persitedClasses = new HashMap<String, ClassAN>();
		for (Class<?> clazz : classes) {
			persitedClasses.put(clazz.getCanonicalName(), new ClassAN(clazz));
		}

		persitedClasses.get(Entity.class.getCanonicalName()).setReference(TestAA.class.getCanonicalName());
		persitedClasses.get(Id.class.getCanonicalName()).setReference(TestAA.class.getCanonicalName());
		persitedClasses.get(GeneratedValue.class.getCanonicalName()).setReference(TestAA.class.getCanonicalName());
		persitedClasses.get(Column.class.getCanonicalName()).setReference(TestAB.class.getCanonicalName());
		persitedClasses.get(Table.class.getCanonicalName()).setReference(TestAB.class.getCanonicalName());

		Session session = null;
		Transaction tx = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			for (Class<?> clazz : classes) {
				session.saveOrUpdate(persitedClasses.get(clazz.getCanonicalName()));
			}
			tx.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}