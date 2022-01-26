# HIBERNATE

## 1. Architecture
4 layers:
- Java application layer
- Hibernate framework layer
- Backend api layer
- Database layer

Elements:
- `SessionFactory`: a factory of session and client of ConnectionProvider
- `Session`: provides an interface between the application and data stored in the database, it is factory of Transaction, Query and Criteria
- `Transaction` (optional): specifies the atomic unit of work
- `ConnectionProvider` (optional): a factory of JDBC connections
- `TransactionFactory` (optional): a factory of Transaction

## 2. Initialization
- Using Annotation: `@Entity`, `@Table(name="")`, `@Id`, `@Column(name="")`, etc.
- Using XML: file name format - `file_name.hbm.xml`
```
<hibernate-mapping>
	<class name="" table="">
		<id name="" type="">
            		<column name="" />
        	</id>
		<property name="" type="">
            		<column name="" length="" />
        	</property>
	</class>
</hibernate-mapping> 
```

## 3. Relationship
### OneToOne
### OneToMany
### ManyToMany

## 4. Fetch Type