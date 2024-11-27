import { Box, Button, InputAdornment, TextField } from '@mui/material'
import React, { useState } from 'react';
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

    var [error, setError] = useState<RegistrationForm>({
        mobileOrEmail: "",
        password: "",
        fullName: "",
        userName: "",
    });
    const [showPassword, setShowPassword] = useState(false);

    const handleClickShowPassword = () => {
        setShowPassword((prevState) => !prevState);
    };

    function validation(type: string) {
        switch (type) {
            case "mobileOrEmail": {
                let email = registrationForm.mobileOrEmail;
                if (email === "") {
                    setError((previousState) => {
                        return { ...previousState, mobileOrEmail: "This field is required" };
                    });
                    return;
                }
                const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                const mobileRegex = /^(\+91)?[ -]?\d{10}$/;
                console.log(!emailRegex.test(email) && !mobileRegex.test(email));
                if (!emailRegex.test(email) && !mobileRegex.test(email)) {
                    let errorMessage = !/^\+?[ -]?[\d]+$/.test(email) ? "Invalid email address" : "Invalid mobile number";
                    console.log(errorMessage);
                    setError((previousState) => {
                        return { ...previousState, mobileOrEmail: errorMessage };
                    });
                } else {

                    setError((previousState) => {
                        return { ...previousState, mobileOrEmail: "" };
                    });
                }
                break;
            }
            case "password": {
                let password = registrationForm.password;
                if (password === "") {
                    setError((previousState) => {
                        return { ...previousState, password: "Create a Password atleast 8 characters long" };
                    });
                    return;
                }
                const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*(),.?":{}|<>])[A-Za-z\d!@#$%^&*(),.?":{}|<>]{8,16}$/;
                if (!passwordRegex.test(password)) {

                    setError((previousState) => {
                        return { ...previousState, password: "Invalid password" };
                    });

                } else {

                    setError((previousState) => {
                        return { ...previousState, password: "" };
                    });
                }

                break;
            }

            default:
                break;
        }
    }
    function handleSubmit(event: React.FormEvent<HTMLFormElement>) {
        // validation();
        event.preventDefault();
    }

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
                <Box sx={styles.registrationForm} component="form" onSubmit={(event) => handleSubmit(event)}>
                    <TextField
                        sx={styles.inputBox}
                        type="text"
                        label='Mobile Number or Email'
                        InputLabelProps={{ shrink: true }}
                        value={registrationForm.mobileOrEmail}
                        onChange={(e) => handleChange(e, "mobileOrEmail")}
                        onBlur={() => validation("mobileOrEmail")}
                        error={!!error.mobileOrEmail}
                        helperText={error.mobileOrEmail}
                    />
                    <TextField
                        sx={styles.inputBox}
                        type={showPassword ? 'text' : 'password'}
                        label='Password'
                        InputLabelProps={{ shrink: true }}
                        InputProps={{
                            endAdornment: (
                                <InputAdornment position="end">
                                    <Button
                                        onClick={handleClickShowPassword}
                                        onMouseDown={(e) => e.preventDefault()}  // Prevent focus loss on click
                                    >
                                        {showPassword ? "Hide" : "Show"}
                                    </Button>
                                </InputAdornment>
                            ),
                        }}
                        value={registrationForm.password}
                        onChange={(e) => handleChange(e, "password")}
                        onBlur={() => validation("password")}
                        error={!!error.password}
                        helperText={error.password}
                    />
                    <TextField type="text" label='Full Name' InputLabelProps={{ shrink: true }} sx={styles.inputBox} value={registrationForm.fullName} onChange={(e) => handleChange(e, "fullName")} />
                    <TextField type="text" label='Username' InputLabelProps={{ shrink: true }} sx={styles.inputBox} value={registrationForm.userName} onChange={(e) => handleChange(e, "userName")} />
                    <Box>People who use our service may have uploaded your contact information to Instagram.</Box>
                    <Box>By signing up, you agree to our Terms , Privacy Policy and Cookies Policy .</Box>
                    <Button variant='contained' color='primary' sx={styles.signUpButton} type='submit'>Sign Up</Button>
                </Box>
            </Box>
        </Box>
    )
}

