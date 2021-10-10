import { Helmet } from 'react-helmet';
import {
  Box,
  Container,
  Grid,
  Pagination
} from '@material-ui/core';
import MyBlogListToolbar from '../components/MyBlog/MyBlogListToolbar';
import MyBlogCard from '../components/MyBlog/MyBlogCard';
import MyBlogs from '../__mocks__/MyBlogs';

const MyBlogList = () => (
  <>
    <Helmet>
      <title>MyBlogs | Hashedin</title>
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
                <MyBlogCard MyBlog={MyBlog} />
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

export default MyBlogList;
