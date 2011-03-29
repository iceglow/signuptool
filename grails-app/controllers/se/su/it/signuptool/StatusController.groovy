package se.su.it.signuptool

import groovy.sql.Sql

class StatusController {
  def dataSource

  def index = {
    def mysql_status = 'FAILED'

    try {
      def sql = new Sql(dataSource);
      def result = sql.rows("select 1")
      mysql_status = (result)?'OK':'FAILED'
    } catch (Exception e) {
    }
    [mysql_status:mysql_status]
  }
}
