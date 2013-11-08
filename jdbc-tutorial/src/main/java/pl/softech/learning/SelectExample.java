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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Sławomir Śledź <slawomir.sledz@sof-tech.pl>
 */
public class SelectExample {

  public static void main(String[] args) throws SQLException {
    
    Properties connectionProps = new Properties();
    connectionProps.put("user", "ssledz");
    connectionProps.put("password", "test");

    try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/sample", connectionProps)) {
      
      PreparedStatement pstm = conn.prepareStatement("SELECT * FROM customer c "
              + "JOIN address a ON a.customer_id = c.id "
              + "WHERE c.firstName = ?");

      pstm.setString(1, "Allan");
      
      ResultSet rs = pstm.executeQuery();
      while(rs.next()) {
        
        System.out.println("FirstName: " + rs.getString("c.firstName"));
        System.out.println("LastName: " + rs.getString("c.lastName"));
        System.out.println("Street: " + rs.getString("a.street"));
        System.out.println("City: " + rs.getString("a.city"));
        
      }
    }
  }
}
