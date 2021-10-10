import { Helmet } from 'react-helmet';
import {
  Box,
  Container,
  Grid,
  Pagination
} from '@material-ui/core';
import { Link } from 'react-router-dom';
import MyBlogListToolbar from '../components/MyBlog/MyBlogListToolbar';
import MyBlogCard from '../components/MyBlog/MyBlogCard';
import MyBlogs from '../__mocks__/MyBlogs';

const Dashboard = () => (
  <>
    <Helmet>
      <title>Dashboard | Hashedin</title>
    </Helmet>
    <Box
      sx={{
        backgroundColor: 'background.default',
        minHeight: '100%',
        py: 3
      }}
    >
      <Container maxWidth={false}>
        <MyBlogListToolbar />
        <Box sx={{ pt: 3 }}>
          <Grid
            container
            spacing={3}
          >
            {MyBlogs.map((MyBlog) => (
              <Grid
                item
                key={MyBlog.id}
                lg={4}
                md={6}
                xs={12}
              >
                <Link
                  to="singleblog"
                >
                  <MyBlogCard MyBlog={MyBlog} />
                </Link>
              </Grid>
            ))}
          </Grid>
        </Box>
        <Box
          sx={{
            display: 'flex',
            justifyContent: 'center',
            pt: 3
          }}
        >
          <Pagination
            color="primary"
            count={3}
            size="small"
          />
        </Box>
      </Container>
    </Box>
  </>
);

export default Dashboard;
