/*
 * Copyright 2013 Sławomir Śledź <slawomir.sledz@sof-tech.pl>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.softech.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Sławomir Śledź <slawomir.sledz@sof-tech.pl>
 */
public class CreateTableExample {

  public static void main(String[] args) throws SQLException {

    Properties connectionProps = new Properties();
    connectionProps.put("user", "ssledz");
    connectionProps.put("password", "test");
    
    try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/sample", connectionProps)) {

      Statement st = conn.createStatement();
      st.executeUpdate("CREATE TABLE customer ("
              + "  id int(11) NOT NULL AUTO_INCREMENT,"
              + "  firstName VARCHAR(100) DEFAULT NULL,"
              + "  lastName VARCHAR(100) DEFAULT NULL,"
              + "  PRIMARY KEY (`id`)"
              + ")");

      st.executeUpdate("CREATE TABLE address ("
              + "  id INT(11) NOT NULL AUTO_INCREMENT, "
              + "  street VARCHAR(100),"
              + "  city VARCHAR(100),"
              + "  customer_id INT(11) NOT NULL,"
              + "  PRIMARY KEY (id),"
              + "  INDEX (customer_id),"
              + "  CONSTRAINT FOREIGN KEY (customer_id)"
              + "    REFERENCES customer(id)"
              + ")");
    }
  }
}
