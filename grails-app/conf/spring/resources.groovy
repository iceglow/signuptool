import org.springframework.jndi.JndiObjectFactoryBean

// Place your Spring DSL code here
beans = {
  ladokDataSource(JndiObjectFactoryBean) {
    jndiName = "java:comp/env/jdbc/ladok"
  }
}