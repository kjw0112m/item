package spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import lombok.Builder;
import spring.entity.ItemDto;

public class ItemDaoImpl implements ItemDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	RowMapper<ItemDto> mapper = new RowMapper<ItemDto>() {

		@Override
		public ItemDto mapRow(ResultSet rs, int index) throws SQLException {
			ItemDto itemDto = null;
			try {
				itemDto = ItemDto.builder()
									.no(rs.getInt("no"))
									.name(rs.getString("name"))
									.type(rs.getString("type"))
									.price(rs.getInt("price"))
									.build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return itemDto;
		}
	};

	@Override
	public void insert(ItemDto dto) {
		String sql = "insert into item values(item_seq.nextval, ?, ?, ?)";
		Object[] param = {dto.getName(),dto.getType(), dto.getPrice()};
		jdbcTemplate.update(sql, param);
	}

	@Override
	public List<ItemDto> list() {
		 String sql = "select * from item order by no";
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public List<ItemDto> get(int no) {
		String sql = "select * from item where no = ?";
		Object[] param = {no};
		return jdbcTemplate.query(sql, param, mapper);
	}

}
