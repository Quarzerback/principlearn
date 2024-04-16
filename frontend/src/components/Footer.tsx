import { Box, Typography } from '@mui/material';

export default function Footer() {
    return (
        <Box
            component="footer"
            sx={{
                backgroundColor: 'primary.main',
                color: 'primary.contrastText',
                py: 2,
                textAlign: 'center',
                position: 'fixed',
                bottom: 0,
                width: '100%',
            }}
        >
            <Typography variant="body2">&copy; 2024 Principlearn</Typography>
        </Box>
    );
}