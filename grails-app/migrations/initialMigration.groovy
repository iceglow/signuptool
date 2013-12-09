/*
 * Copyright (c) 2013, IT Services, Stockholm University
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * Neither the name of Stockholm University nor the names of its contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

databaseChangeLog = {

	changeSet(author: "jolu (generated)", id: "1386317551266-1") {
		createTable(tableName: "access_role") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "display_name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "uri", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "jolu (generated)", id: "1386317551266-2") {
		createTable(tableName: "event_log") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "VARCHAR(255)")
		}
	}

	changeSet(author: "jolu (generated)", id: "1386317551266-3") {
		createTable(tableName: "event_log_event") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "LONGTEXT") {
				constraints(nullable: "false")
			}

			column(name: "event_log_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "time_created", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "jolu (generated)", id: "1386317551266-4") {
		createTable(tableName: "localization") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "code", type: "VARCHAR(250)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "loc", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "relevance", type: "TINYINT") {
				constraints(nullable: "false")
			}

			column(name: "text", type: "LONGTEXT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "jolu (generated)", id: "1386317551266-5") {
		createTable(tableName: "role_controller_access") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "controller", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "jolu (generated)", id: "1386317551266-6") {
		createTable(tableName: "role_controller_access_access_role") {
			column(name: "role_controller_access_roles_id", type: "BIGINT")

			column(name: "access_role_id", type: "BIGINT")
		}
	}

	changeSet(author: "jolu (generated)", id: "1386317551266-7") {
		createTable(tableName: "section") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "jolu (generated)", id: "1386317551266-8") {
		createTable(tableName: "value") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "is_default", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "section_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "value", type: "LONGTEXT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "jolu (generated)", id: "1386317551266-13") {
		createIndex(indexName: "uri", tableName: "access_role", unique: "true") {
			column(name: "uri")
		}
	}

	changeSet(author: "jolu (generated)", id: "1386317551266-14") {
		createIndex(indexName: "code", tableName: "localization", unique: "true") {
			column(name: "code")

			column(name: "loc")
		}
	}

	changeSet(author: "jolu (generated)", id: "1386317551266-15") {
		createIndex(indexName: "localizations_idx", tableName: "localization", unique: "false") {
			column(name: "code")

			column(name: "loc")
		}
	}

	changeSet(author: "jolu (generated)", id: "1386317551266-16") {
		createIndex(indexName: "controller", tableName: "role_controller_access", unique: "true") {
			column(name: "controller")
		}
	}

	changeSet(author: "jolu (generated)", id: "1386317551266-17") {
		createIndex(indexName: "name", tableName: "section", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "jolu (generated)", id: "1386317551266-9") {
		addForeignKeyConstraint(baseColumnNames: "event_log_id", baseTableName: "event_log_event", baseTableSchemaName: "signuptool", constraintName: "FK9EBA6A7ABE6A8050", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "event_log", referencedTableSchemaName: "signuptool", referencesUniqueColumn: "false")
	}

	changeSet(author: "jolu (generated)", id: "1386317551266-10") {
		addForeignKeyConstraint(baseColumnNames: "access_role_id", baseTableName: "role_controller_access_access_role", baseTableSchemaName: "signuptool", constraintName: "FKCDC88390450141DE", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "access_role", referencedTableSchemaName: "signuptool", referencesUniqueColumn: "false")
	}

	changeSet(author: "jolu (generated)", id: "1386317551266-11") {
		addForeignKeyConstraint(baseColumnNames: "role_controller_access_roles_id", baseTableName: "role_controller_access_access_role", baseTableSchemaName: "signuptool", constraintName: "FKCDC883907F77404F", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "role_controller_access", referencedTableSchemaName: "signuptool", referencesUniqueColumn: "false")
	}

	changeSet(author: "jolu (generated)", id: "1386317551266-12") {
		addForeignKeyConstraint(baseColumnNames: "section_id", baseTableName: "value", baseTableSchemaName: "signuptool", constraintName: "FK6AC917156317581", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "section", referencedTableSchemaName: "signuptool", referencesUniqueColumn: "false")
	}
}
