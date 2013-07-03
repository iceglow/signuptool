databaseChangeLog = {

  changeSet(author: "mano3567 (generated)", id: "1372836399550-2") {
    createTable(tableName: "event_log") {
      column(autoIncrement: "true", name: "id", type: "bigint") {
        constraints(nullable: "false", primaryKey: "true", primaryKeyName: "event_logPK")
      }

      column(name: "version", type: "bigint") {
        constraints(nullable: "false")
      }

      column(name: "date_created", type: "datetime") {
        constraints(nullable: "false")
      }

      column(name: "description", type: "varchar(255)") {
        constraints(nullable: "false")
      }

      column(name: "last_updated", type: "datetime") {
        constraints(nullable: "true")
      }

      column(name: "local_server", type: "varchar(255)") {
        constraints(nullable: "true")
      }

      column(name: "reference_id", type: "varchar(255)") {
        constraints(nullable: "true")
      }

      column(name: "remote_host", type: "varchar(255)") {
        constraints(nullable: "true")
      }

      column(name: "social_security_number", type: "varchar(255)") {
        constraints(nullable: "true")
      }

      column(name: "user_id", type: "varchar(255)") {
        constraints(nullable: "true")
      }
    }
  }
}


