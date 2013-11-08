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
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Sławomir Śledź <slawomir.sledz@sof-tech.pl>
 */
public class AdvanceInsertRowsExample {

  public static void main(String[] args) throws SQLException {
    Properties connectionProps = new Properties();
    connectionProps.put("user", "ssledz");
    connectionProps.put("password", "test");

    try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/sample", connectionProps)) {

      PreparedStatement pstm = conn.prepareStatement(//
              "INSERT INTO customer(firstName, lastName)"
              + " VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

      PreparedStatement pstmCreateAddress = conn.prepareStatement(//
              "INSERT INTO address(street,city,customer_id) "
              + "values (?, ? , ?)");

      String[][] customers = {
        {"Allan", "Turing"},
        {"Dennis", "Ritchie"},
        {"Brian", "Kernighan"}
      };

      String[][] addresses = {
        {"street1", "city1"},
        {"street2", "city2"},
        {"street2", "city2"},};

      for (int i = 0; i < customers.length; i++) {

        pstm.setString(1, customers[i][0]);
        pstm.setString(2, customers[i][1]);
        pstm.executeUpdate();

        ResultSet rs = pstm.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);

        pstmCreateAddress.setString(1, addresses[i][0]);
        pstmCreateAddress.setString(2, addresses[i][1]);
        pstmCreateAddress.setInt(3, id);
        pstmCreateAddress.executeUpdate();
      }

    }
  }
}
