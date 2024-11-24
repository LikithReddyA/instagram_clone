import { Box, Button, TextField } from '@mui/material'
import React, { useState } from 'react';
import "./registration.css"
import registrationStyles from "./registration.styles"

interface RegistrationForm {
    mobileOrEmail: string,
    password: string,
    fullName: string,
    userName: string,

}

export default function Registration() {
    var [registrationForm, setRegistrationForm] = useState<RegistrationForm>({
        mobileOrEmail: "",
        password: "",
        fullName: "",
        userName: "",
    });

    const handleChange = (event: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, key: any) => {
        setRegistrationForm(previousState => {
            return { ...previousState, [key]: event.target.value }
        })

    }
    var styles = registrationStyles();
    return (
        <Box sx={styles.main} >
            <Box sx={styles.outerWidget}>
                <h2>Instagram</h2>
                <h6>Sign up to see photos and videos from your friends.</h6>
                <Box sx={styles.registrationForm} component="form">
                    <TextField type="text" placeholder='Mobile Number or Email' sx={styles.inputBox} value={registrationForm.mobileOrEmail} onChange={(e) => handleChange(e, "mobileOrEmail")} />
                    <TextField type="password" placeholder='Password' sx={styles.inputBox} value={registrationForm.password} onChange={(e) => handleChange(e, "password")} />
                    <TextField type="text" placeholder='Full Name' sx={styles.inputBox} value={registrationForm.fullName} onChange={(e) => handleChange(e, "fullName")} />
                    <TextField type="text" placeholder='Username' sx={styles.inputBox} value={registrationForm.userName} onChange={(e) => handleChange(e, "userName")} />
                    <Box>People who use our service may have uploaded your contact information to Instagram.</Box>
                    <Box>By signing up, you agree to our Terms , Privacy Policy and Cookies Policy .</Box>
                    <Button variant='contained' color='primary' sx={styles.signUpButton} onClick={() => { console.log(registrationForm) }} >Sign Up</Button>
                </Box>
            </Box>
        </Box>
    )
}

