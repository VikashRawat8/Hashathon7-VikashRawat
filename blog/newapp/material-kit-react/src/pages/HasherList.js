import { Helmet } from 'react-helmet';
import { Box, Container } from '@material-ui/core';
import HasherListResults from '../components/Hasher/HasherListResults';
import HasherListToolbar from '../components/Hasher/HasherListToolbar';
import Hashers from '../__mocks__/Hashers';

const HasherList = () => (
  <>
    <Helmet>
      <title>Hashers | Hashedin</title>
    </Helmet>
    <Box
      sx={{
        backgroundColor: 'background.default',
        minHeight: '100%',
        py: 3
      }}
    >
      <Container maxWidth={false}>
        <HasherListToolbar />
        <Box sx={{ pt: 3 }}>
          <HasherListResults Hashers={Hashers} />
        </Box>
      </Container>
    </Box>
  </>
);

export default HasherList;
