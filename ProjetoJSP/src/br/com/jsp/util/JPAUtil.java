package br.com.jsp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Será o nucleo do projeto
 * @author Harmfull
 *
 */
public class JPAUtil {

	// instancia unica do entityManagerdFactory
	private static EntityManagerFactory factory = null;

	/**
	 * Deve ser criada uma unica vez
	 */
	static {
		// se nao existir uma instancia, será criada
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("ProjetoJSP");
		}
	}

	//retorna um EntityManager
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}


	/**
	 * Irá retornar o id da entidade persistida no banco de dados
	 * 
	 * @param entity
	 * @return
	 */
	public static Object getPrimaryKey(Object entity) {
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}
}
