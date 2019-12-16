package com.arobs.ArobsMeetup.repository;

import com.arobs.ArobsMeetup.configuration.Datasource;
import com.arobs.ArobsMeetup.entity.ProposalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProposalRepository implements DBRepository<ProposalEntity> {

    @Autowired
    private Datasource datasource;
    public ProposalRepository() throws SQLException{}

    @Override
    public int add(ProposalEntity proposal) throws SQLException {
        String querry = "INSERT INTO proposal(title,proposer_id,description,ptype,difficulty," +
                "planguage, duration, max_attends) VALUES (?,?,?,?,?,?,?,?)";
        try (
                Connection connection = datasource.customDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(querry);
        ) {

            preparedStatement.setString(1, proposal.getTitle());
            preparedStatement.setInt(2, proposal.getProposer_id());
            preparedStatement.setString(3, proposal.getDescription());
            preparedStatement.setString(4, proposal.getType());
            preparedStatement.setString(5, proposal.getDifficulty());
            preparedStatement.setString(6, proposal.getLanguage());
            preparedStatement.setInt(7, proposal.getDuration());
            preparedStatement.setInt(8, proposal.getMax_attends());

            int inserted = preparedStatement.executeUpdate();
            if (inserted == 1) {
                return 1;
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(ProposalEntity elem) throws SQLException {
        return 0;
    }

    @Override
    public int remove(ProposalEntity elem) throws SQLException {
        return 0;
    }

    @Override
    public ProposalEntity find(int id) throws SQLException {
        return null;
    }

    @Override
    public List<ProposalEntity> findAll() throws SQLException {
        return null;
    }
}
